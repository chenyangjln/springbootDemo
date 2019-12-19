package com.example.demo.config;

import com.example.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration : 指明当前类是一个配置类，相当于spring的配置文件
 * 以前在配置文件中是通过<bean></bean>标签来添加组件的
 * @author Alex
 * @create 2019-12-19 11:44
 */
@Configuration
public class MyAppConfig {

    /**
     * 将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
     * @return
     */
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@bean给容器中添加组件了。。。");
        return new HelloService();
    }
}
