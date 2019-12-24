# Spring Boot HelloWorld
需求：浏览器发送hello请求，服务器接收请求并处理，响应hello world字符串
## Hello World探究
### pom文件
#### 父项目
```java
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.1.RELEASE</version>
    </parent> 
    它的父项目   
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
        <version>2.2.1.RELEASE</version>
        <relativePath>../../spring-boot-dependencies</relativePath>
     </parent>
```
     它来真正管理spring boot应用里面的所有依赖版本。（叫spring boot的版本仲裁中心）
     所以以后我们导入依赖是默认不需要写版本的（但是，没有在dependencies里面管理的依赖自然需要声明版本号）。
### 启动器
```java
    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
    </dependency>   
```
   #### spring-boot-starter-web
   spring-boot-starter:spring-boot场景启动器（帮我们导入了web模块正常运行所依赖的组件）。
   spring boot将所有的组件都抽取出来，做成了一个个的starters（启动器），只需要在项目中引入相关场景启动器，
   就会自动将所有的依赖导入进项目，并从版本的仲裁中心自动获取相关的版本号。
   
   #### 主程序类（@SpringBootApplication）
   ```java
       @Target({ElementType.TYPE})
       @Retention(RetentionPolicy.RUNTIME)
       @Documented
       @Inherited
       @SpringBootConfiguration
       @EnableAutoConfiguration
       @ComponentScan(excludeFilters = {
       @Filter(type = FilterType.CUSTOM,classes = {TypeExcludeFilter.class}), 
       @Filter(type = FilterType.CUSTOM,classes = {AutoConfigurationExcludeFilter.class})})
       public @interface SpringBootApplication {   }
```
   
   **@SpringBootConfiguration**：spring boot的配置类（标注在某个类上，表示这是一个spring boot的配置类）；
        - @Configuration：配置类上来标注这个注解。
        - 配置类 就相当于 配置文件；配置类也是容器中的一个组件（@Component）。
        
   **@EnableAutoConfiguration**：开启自动配置功能；
        - 以前我们需要配置的东西，现在spring boot帮我们自动配置；注解@EnableAutoConfiguration告诉spring boot开启自动配置功能，
            这样自动配置才能生效。
   ```java
        @AutoConfigurationPackage
        @Import({AutoConfigurationImportSelector.class})
        public @interface EnableAutoConfiguration {}
```
        @AutoConfigurationPackage:自动配置包，
        **作用：将主配置类（@SpringBootAllication标注的类）的所在包及下面子包里面的所有组件扫描到spring容器中。**
            - @Import({Registrar.class})：spring的底层注解@import，作用：给容器中导入一个组件，组件由Registrar.class来指定。
            
        @Import({AutoConfigurationImportSelector.class})
            - AutoConfigurationImportSelector ：导入那些组件的选择器
            - public String[] selectImports(AnnotationMetadata annotationMetadata)；
                将所有需要的组件以全类名的方式返回String[]类型，这些组件就会被添加到容器中。
                这些组件会给容器中导入非常多的自动配置类（xxxAutoConfiguration），就是给容器中导入这个场景需要的所有的组件，
                并配置好这些组件。
            - 有了自动配置类，就可以免去我们手动编写配置和注入功能组件等的工作。
            
        SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class,ClassLoader)
            - 从类路径（"META-INF/spring.factories"）中获取EnableAutoConfiguration指定的值。

### 总结
    **Spring Boot 在启动时，从类路径META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将这些值作为自动配置类导入
    到容器中，自动配置类就会生效，帮我们进行自动配置工作。** 以前我们需要自己配置的东西，自动配置类都帮我们自动配置了。
    
**J2EE的整体整合解决方案和自动配置都在spring-boot-autoconfigure-2.2.1.RELEASE.jar中**    
            
       