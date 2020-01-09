package com.danny.blog.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 事务提交
 *
 * Created by Danny on 2018/6/10.
 */
@Configuration
public class SessionFactoryConfiguratiion {

    // mybatis_config.xml 配置文件路径
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    // mybatis mapper文件所在路径
    @Value("${mapper_path}")
    private String mapperPath;
    // 实体类所在的package
    @Value("${entity_package}")
    private String entityPackage;
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置mybatisConfiguration扫描路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // mapper路径
        String packageSeatchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        // 指定mapper文件的扫描路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSeatchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 映射实体类
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);

        return sqlSessionFactoryBean;
    }
}
