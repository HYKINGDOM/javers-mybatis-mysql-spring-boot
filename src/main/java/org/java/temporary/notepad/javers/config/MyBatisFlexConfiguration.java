package org.java.temporary.notepad.javers.config;

import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.audit.AuditManager;
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
public class MyBatisFlexConfiguration implements ConfigurationCustomizer {

    private static final Logger logger = LoggerFactory.getLogger("mybatis-flex-sql");


    public MyBatisFlexConfiguration() {

        //开启审计功能
        AuditManager.setAuditEnable(true);

        //设置审计工厂创建审计消息
        AuditManager.setMessageFactory(new MybatisFlexAuditMessageFactory());

        AuditManager.setMessageCollector(auditMessage -> logger.info("massage: {}", auditMessage.toString()));
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
}