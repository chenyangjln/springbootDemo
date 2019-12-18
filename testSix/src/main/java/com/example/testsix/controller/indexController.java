package com.example.testsix.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在创建拦截器之前我们需要添加初始化登录页面的转发配置，我们创建IndexController添加初始化登录、首页页面转发配置
 * @author Alex
 * @create 2019-12-03 20:48
 */
@RestController
@RequestMapping(value = "/user")
public class indexController {

    /**
     * 初始化登录页面
     * @return
     */
    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login_view() {
        return "login";
    }

    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
