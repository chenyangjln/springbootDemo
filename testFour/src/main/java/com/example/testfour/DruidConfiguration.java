package com.example.testfour;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 实现Druid的访问Servlet以及Filter
 *
 * 开启监控功能，可以在应用运行的过程中，通过监控提供的多维度数据来分析使用数据库的运行情况，从而可以调整程序设计，
 * 以便于优化数据库的访问性能。
 * @Configuration 注解是用来配置SpringBoot项目的配置注解，如果将该注解配置在实体类上，该类内的所有bean以及配置都会应用的全局。
 * @author Alex
 * @create 2019-12-03 16:17
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean StatViewServlet(){
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        //设置ip白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //设置ip黑名单，如果allow与deny共同存在时,deny优先于allow
        servletRegistrationBean.addInitParameter("deny" , "192.168.0.19");
        //设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername" , "druid");
        servletRegistrationBean.addInitParameter("loginPassword" , "123456");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable" , "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
}
