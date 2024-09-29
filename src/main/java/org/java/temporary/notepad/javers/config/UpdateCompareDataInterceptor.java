//package org.java.temporary.notepad.javers.config;
//
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Plugin;
//import org.apache.ibatis.plugin.Signature;
//
//import java.util.Properties;
//
//@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
//public class UpdateCompareDataInterceptor implements Interceptor {
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        // 获取被拦截方法参数
//        Object[] args = invocation.getArgs();
//        MappedStatement mappedStatement = (MappedStatement)args[0];
//        Object parameter = args[1];
//
//        // 获取SQL ID
//        String sqlId = mappedStatement.getId();
//
//        // 执行更新前的数据查询
//        Object originalData = queryOriginalData(parameter);
//
//        // 执行方法
//        Object result = invocation.proceed();
//
//        // 更新后的数据查询
//        Object updatedData = queryUpdatedData(parameter);
//
//        // 比较差异并记录日志
//        logDifference(originalData, updatedData);
//
//        return result;
//    }
//
//    private Object queryOriginalData(Object parameter) {
//        // 根据parameter查询原始数据
//        // 这里需要根据实际情况编写查询逻辑
//        return null;
//    }
//
//    private Object queryUpdatedData(Object parameter) {
//        // 根据parameter查询更新后的数据
//        // 这里需要根据实际情况编写查询逻辑
//        return null;
//    }
//
//    private void logDifference(Object originalData, Object updatedData) {
//        // 比较originalData和updatedData的差异
//        // 打印日志
//        // 这里需要根据实际情况编写日志打印逻辑
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//        // 可以读取配置文件中的属性
//    }
//}
