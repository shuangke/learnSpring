package com.shuangke.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.shuangke")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class UserConfig {
    @Bean
    public DataSource dataSource(@Value("${jdbc.driverClassName}") String driverClassName,
                                    @Value("${jdbc.url}") String url,
                                    @Value("${jdbc.username}") String username,
                                    @Value("${jdbc.password}") String password) {
        // 创建数据源对象并设置属性
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;

    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
