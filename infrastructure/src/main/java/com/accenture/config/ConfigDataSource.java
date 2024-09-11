package com.accenture.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Project TestProject
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */

@Configuration
public class ConfigDataSource {

    @Bean
    DataSource getDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("hexagonal");
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("Juniorndjog@007");
        dataSource.setServerTimezone("UTC");
        return dataSource;
    }
}
