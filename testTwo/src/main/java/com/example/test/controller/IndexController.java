package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Alex
 * @create 2019-12-02 17:33
 */
@Controller
public class IndexController {
    /**
     * 上述步骤中配置的application.properties文件的springmvc请求前缀以及后缀，
     * 那么当我们访问/index时springmvc就会去找/webapp/WEB-INF/jsp/index.jsp文件
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
