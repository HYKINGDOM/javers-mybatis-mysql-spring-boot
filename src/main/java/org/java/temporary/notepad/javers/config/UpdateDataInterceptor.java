package org.java.temporary.notepad.javers.config;

import com.mybatisflex.annotation.Id;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * MyBatis 更新数据拦截器, 比较更新前后数据差异
 *
 * @author kscs
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class UpdateDataInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(UpdateDataInterceptor.class);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取 MappedStatement 对象
        MappedStatement ms = (MappedStatement)invocation.getArgs()[0];
        // 获取更新前的数据
        Object param = invocation.getArgs()[1];
        // 获取主键值
        Object primaryKeyValue = getPrimaryKeyValue(param);

        // 通过主键查询更新前的数据
        Object oldData = selectByPrimaryKey(ms, primaryKeyValue);

        // 比较更新前后的数据差异
        compareData(oldData, param);

        // 继续执行原有的更新逻辑
        return invocation.proceed();
    }

    private Object selectByPrimaryKey(MappedStatement ms, Object primaryKeyValue) throws SQLException {
        BoundSql boundSql = ms.getBoundSql(primaryKeyValue);
        Map<String, Object> params = new HashMap<>();
        params.put("id", primaryKeyValue);
        return ms.getConfiguration().getMappedStatement("selectOneById").getConfiguration().newExecutor(null)
            .query(ms, params, new RowBounds(0, 1), (ResultHandler<Object>)resultContext -> {
            }).getFirst();
    }

    private Object getPrimaryKeyValue(Object param) {
        try {
            for (Field field : param.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class)) {
                    field.setAccessible(true);
                    return field.get(param);
                }
            }
        } catch (Exception e) {
            logger.error("获取主键值失败", e);
        }
        return null;
    }

    private void compareData(Object oldData, Object newData) {
        try {
            for (Field field : oldData.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object oldValue = field.get(oldData);
                Object newValue = field.get(newData);
                if (!Objects.equals(oldValue, newValue)) {
                    logger.info("字段 {} 由 {} 变更为 {}", field.getName(), oldValue, newValue);
                }
            }
        } catch (Exception e) {
            logger.error("比较数据差异失败", e);
        }
    }

}
