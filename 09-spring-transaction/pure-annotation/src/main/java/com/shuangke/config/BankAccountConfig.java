package com.shuangke.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.shuangke")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class BankAccountConfig {
    //1.配置数据源
    @Bean
    public DataSource dataSource(@Value("${jdbc.mysql.DriverClassName}") String driverClassName,
                                 @Value("${jdbc.mysql.url}") String url,
                                 @Value("${jdbc.mysql.username}") String username,
                                 @Value("${jdbc.mysql.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    //2. 配置JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    //3. 配置事务管理器for JdbcTemplate
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
