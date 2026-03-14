package com.shuangke.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//use a configuration class to replace the xml configuration file, and use @Bean annotation to define beans in the configuration class
@Configuration
@ComponentScan("com.shuangke")
@PropertySource(value={"classpath:jdbc.properties", "classpath:school-info.properties"})
public class Config {

    // the bean id will be the method name by default, and the method return type is the bean type
    @Bean
    public DataSource dataSource(@Value("${jdbc.url}") String url,
                                 @Value("${jdbc.username}") String username,
                                 @Value("${jdbc.password}") String password,
                                 @Value("${jdbc.classname}") String driverClassName) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
