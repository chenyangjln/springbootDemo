package com.example.testsix.conpent;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建一个名叫做SessionInterceptor的拦截器实体类，实现SpringMVC内部接口HandlerInterceptor，
 * 并且添加如果没有session状态直接跳转到/user/login_view地址也就是我们对应的login.jsp页面
 * @author Alex
 * @create 2019-12-03 20:53
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        //登录不做拦截
        if(request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/login_view")){
            return true;
        }
        //验证session是否存在
        Object obj =  request.getSession().getAttribute("_session_user");
        if(obj == null){
            response.sendRedirect("/user/login_view");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
