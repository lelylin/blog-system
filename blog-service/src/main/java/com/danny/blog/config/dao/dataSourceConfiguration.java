package com.danny.blog.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * Created by Danny on 2018/6/10.
 */
@Configuration // spring容器需要到该类下解锁相关的bean
@MapperScan("com.danny.dao")// 配置mybatis mapper的扫描路径
public class dataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 数据库连接驱动
        dataSource.setDriverClass(jdbcDriver);
        // 连接url
        dataSource.setJdbcUrl(jdbcUrl);
        // 用户名
        dataSource.setUser(jdbcUsername);
        // 密码
        dataSource.setPassword(jdbcPassword);
        // 连接池关闭时否做自动提交 false:不自动提交
        dataSource.setAutoCommitOnClose(false);

        return  dataSource;
    }
}
