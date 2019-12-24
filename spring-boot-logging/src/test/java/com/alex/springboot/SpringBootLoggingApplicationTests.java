package com.alex.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootLoggingApplicationTests {

//    日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
//        System.out.println("yes");
        /*日志的级别，由低到高，trace<debug<info<warn<error
        * 作用：可以调整需要输出的日志级别，日志就会再这个级别和以后的高级别生效*/
        logger.trace("这是trace日志，跟踪轨迹的意思，框架再运行过程中跟踪一些信息");
        logger.debug("这是debug日志，调试信息，框架运行到关键步骤，调试一些信息");
        /**
         * spring boot默认给我们使用的是info级别的
         * 2019-12-23 11:15:19.384  INFO 12304 --- [           main] c.a.s.SpringBootLoggingApplicationTests  : 这是info日志，输出自己定义的信息
         * 2019-12-23 11:15:19.384  WARN 12304 --- [           main] c.a.s.SpringBootLoggingApplicationTests  : 这是warn日志，警告信息
         * 2019-12-23 11:15:19.384 ERROR 12304 --- [           main] c.a.s.SpringBootLoggingApplicationTests  : 这是error日志，错误信息，比如捕获异常
         *
         * 级别调整在properties配置文件中配置：logging.level.com.alex=trace
         * 2019-12-23 11:20:18.017 TRACE 13544 --- [           main] c.a.s.SpringBootLoggingApplicationTests  : 这是trace日志，跟踪轨迹的意思，框架再运行过程中跟踪一些信息
         * 2019-12-23 11:20:18.017 DEBUG 13544 --- [           main] c.a.s.SpringBootLoggingApplicationTests  : 这是debug日志，调试信息，框架运行到关键步骤，调试一些信息
         * 2019-12-23 11:20:18.017  INFO 13544 --- [           main] c.a.s.SpringBootLoggingApplicationTests  : 这是info日志，输出自己定义的信息
         * 2019-12-23 11:20:18.017  WARN 13544 --- [           main] c.a.s.SpringBootLoggingApplicationTests  : 这是warn日志，警告信息
         * 2019-12-23 11:20:18.017 ERROR 13544 --- [           main] c.a.s.SpringBootLoggingApplicationTests  : 这是error日志，错误信息，比如捕获异常
         */
        logger.info("这是info日志，输出自己定义的信息");
        logger.warn("这是warn日志，警告信息");
        logger.error("这是error日志，错误信息，比如捕获异常");
    }

}