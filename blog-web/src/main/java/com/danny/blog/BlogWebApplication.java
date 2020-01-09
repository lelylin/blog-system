package com.danny.blog;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * SpringBoot使用事务的步骤：
 * 1、在入口类中使用注解@EnableTransactionManagement，开启事务支持
 * 2、在访问数据库的Service方法上添加注解@Transactional即可
 *
 * SpringBoot使用拦截器
 * 1、按照Spring Mvc的方式编写一个拦截器类
 * 2、编写一个配置类继承WebMvcConfigurerAdapter类
 * 3、为该配置类添加@Configuration注解，标注此类为一个配置类，让Springboot扫描到
 * 4、覆盖其中的方法并添加已经编写好的拦截器
 * @Override
 * public void addInterceptors(InterceptorRegistry registry){
 *     // 对来自/api/** 链接的请求进行拦截，对登录请求的/api/login不进行拦截
 *     registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/**").excludePathPatterns(/api/login);
 * }
 */

@SpringBootApplication
@EnableTransactionManagement //开启SpringBoot事务支持
//@ComponentScan(basePackages={"com.danny.blog"})
//@MapperScan(basePackages={"com.danny.blog.service.dao"})
public class BlogWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogWebApplication.class, args);
    }

    /**
     *  配置mybatis的分页插件pageHelper
     */
    @Bean
    public PageHelper pageHelper(){
        System.out.println("开始配置数据分页插件");
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        //配置mysql数据库的方言
        properties.setProperty("dialect","mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}

