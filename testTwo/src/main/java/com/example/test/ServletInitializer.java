package com.example.test;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 现在JavaConfig配置方式在逐步取代xml配置方式。
 * 而WebApplicationInitializer可以看做是Web.xml的替代，它是一个接口。
 * 通过实现WebApplicationInitializer，在其中可以添加servlet，listener等，
 * 在加载Web项目的时候会加载这个接口实现类，从而起到web.xml相同的作用。
 *
 * SpringBootServletInitializer这个类是springboot提供的web程序初始化的入口，
 * 当我们使用外部容器（后期文章讲解使用外部tomcat如何运行项目）运行项目时会自动加载并且装配。
 * @author Alex
 * @create 2019-12-01 16:53
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * 实现了SpringBootServletInitializer的子类需要重写一个configure方法，
     * 方法内自动根据TestApplication.class的类型创建一个SpringApplicationBuilder交付给springboot框架来完成初始化运行配置
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TestApplication.class);
    }
}
