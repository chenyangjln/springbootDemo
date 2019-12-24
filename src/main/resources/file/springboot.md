# spring boot
## spring boot的优点：
    - 快速创建独立运行的spring项目以及与主流框架的集成；
    - 使用嵌入式的Servlet容器，应用无需打成war包；
    - starters自动依赖与版本控制；
    - 大量的自动配置，简化开发，也可以修改默认值；
    - 无需配置XML，无代码生成，开箱即用；
    - 准生产环境的运行时应用监控；
    - 与云计算的天然集成。
## spring boot的缺点：
    - 入门容易，精通难；spring boot是对spring框架的再封装；
    - 如果对spring的底层框架不是很了解，那么就会对spring boot的整个封装机制就不会很了解；
    - spring boot源码中大量的配置都需要掌握spring底层的API，只有对spring底层的API精通之后，才能对spring boot进行生物定制。
# 微服务
## 简介
    - 2014，Martin fowler；
    - 微服务是一种架构的风格；
    - 特点：一个应用应该是一组小型的服务，每一个小型服务之间通过HTTP的方式进行互通。
    - 好处：后台维护的时候，只需要停掉相关的服务进行维护即可，其他的服务还能进行运行。
            每一个功能元素最终都是一个可独立替换和独立升级的软件单元。
## 单体应用和微服务
    - 一个单体应用程序把它所有的功能都放在一个单一的进程中。
        扩展的时候，是通过在多个服务器上复制这个单体应用来进行扩展。
    - 一个微服务架构把每个功能元素放在一个独立的服务中。
        并且通过跨服务器分发这些服务进行扩展，只在需要时才复制。
        
### 默认生成的spring boot项目resource文件夹的目录结构
    - static：保存所有的静态资源；js,css,images;
    - templates：保存所有的模板页面。（虽然spring boot默认jar包使用的是嵌入式的Tomcat（默认不支持JSP页面），
        但是我们可以使用模板引擎（freemarker,thymeleaf））；
    - application.properties：spring boot应用的配置文件，可以修改一些默认配置。   