package org.java.temporary.notepad.javers.config;

import com.alibaba.druid.support.json.JSONUtils;
import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.audit.ConsoleMessageCollector;
import com.mybatisflex.core.audit.MessageCollector;
import com.mybatisflex.core.audit.MessageFactory;
import com.mybatisflex.core.datasource.FlexDataSource;
import com.mybatisflex.core.dialect.DbType;
import com.mybatisflex.core.mybatis.FlexConfiguration;
import com.mybatisflex.spring.boot.ConfigurationCustomizer;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;
import jakarta.annotation.Resource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kscs
 */
@Configuration
public class MyBatisFlexConfiguration implements ConfigurationCustomizer, MyBatisFlexCustomizer {

    private static final Logger logger = LoggerFactory.getLogger("mybatis-flex-sql");

    @Resource
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    public MyBatisFlexConfiguration() {

        //开启审计功能
        AuditManager.setAuditEnable(true);

        //设置审计工厂创建审计消息
        AuditManager.setMessageFactory(new MybatisFlexAuditMessageFactory());

        AuditManager.setMessageCollector(
            auditMessage -> logger.info("massage: {}", auditMessage.toString()));
    }

    /**
     * 自定义配置
     *
     * @param configuration MyBatis Flex Configuration
     */
    @Override
    public void customize(FlexConfiguration configuration) {
        //mybatis实现的打印sql到控制台，便于调试
        configuration.setLogImpl(StdOutImpl.class);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(Interceptor... interceptors) throws Exception {
        // 添加拦截器
        sqlSessionFactoryBean.setPlugins(interceptors);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public UpdateDataInterceptor updateDataInterceptor() {
        return new UpdateDataInterceptor();
    }
    @Override
    public void customize(FlexGlobalConfig flexGlobalConfig) {
    }
}