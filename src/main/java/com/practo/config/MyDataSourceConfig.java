package com.practo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MyDataSourceConfig {

    @Bean
    public DataSource dataSource() {
        // Configure your datasource details here (driver class, url, username, password etc.)
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/practo_db");
        dataSource.setUsername("root");
        dataSource.setPassword("test");
        return dataSource;
    }
}
