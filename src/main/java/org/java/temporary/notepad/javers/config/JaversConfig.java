package org.java.temporary.notepad.javers.config;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.repository.sql.ConnectionProvider;
import org.javers.repository.sql.DialectName;
import org.javers.repository.sql.JaversSqlRepository;
import org.javers.repository.sql.SqlRepositoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author kscs
 */
@Configuration
public class JaversConfig {

    @Bean
    public Javers javers(DataSource dataSource) {
        ConnectionProvider connectionProvider = dataSource::getConnection;
//
//        JdbcSqlRepositoryCustomizer customizer = sqlRepository -> {
//            sqlRepository.withDialect(DialectName.MYSQL);
//            // 可以在这里进行其他自定义配置
//        };

        return JaversBuilder.javers()
            .build();
    }
}