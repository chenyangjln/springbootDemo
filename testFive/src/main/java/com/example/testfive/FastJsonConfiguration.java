package com.example.testfive;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * WebMvcConfigurerAdapter这个类是SpringBoot内部提供专门处理用户自行添加的配置，
 * 里面不仅仅包含了修改视图的过滤还有其他很多的方法，包括我们后面章节要讲到的拦截器，过滤器，Cors配置等
 *
 * @author Alex
 * @create 2019-12-03 17:26
 */
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {

    /**
     * 由于WebMvcConfigurerAdapter已废弃，配置类继承WebMvcConfigurerAdapter的方式改为实现WebMvcConfigurer接口，
     * 然后接口中的方法都是default的，不需要全部重写
     *
     * @param converters 消息转换器列表
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //将fastjson添加到视图消息转换器列表内
        converters.add(fastJsonHttpMessageConverter);
    }

    /**
     * 修改自定义消息转换器
     *
     * fastJson配置实体调用setSerializerFeatures方法可以配置多个过滤方式，下面我们来介绍下常用的SerializerFeatures配置。
     *      WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
     *      WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
     *      DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
     *      WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
     *      WriteMapNullValue：是否输出值为null的字段,默认为false。
     *
     * @param converters 消息转换器列表
     */
    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //调用父类的配置
        super.configureMessageConverters(converters);
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //将fastjson添加到视图消息转换器列表内
        converters.add(fastJsonHttpMessageConverter);
    }*/
}
