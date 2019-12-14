package com.example.testsix.controller;


import com.example.testsix.entity.UserEntity;
import com.example.testsix.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author Alex
 * @create 2019-12-03 19:32
 */
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserJpa userJpa;

    @RequestMapping(value = "/login")
    public String login(UserEntity user, HttpServletRequest request){
        //登录成功
        boolean flag = true;
        String result = "登录成功";
        //根据用户名查询用户是否存在,使用SpringDataJPA从数据库中查询指定用户，然后再比对密码是否符合
        Optional<UserEntity> entity = userJpa.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
                return null;
            }
        });
       //用户不存在
        if(entity == null){
            flag = false;
            result =  "用户不存在，登录失败";
        }else if(! entity.get().getPwd().equals(user.getPwd())){
            flag = false;
            result = "用户密码不相符，登录失败" ;
        }

        //登录成功
        if(flag){
            //将用户写入session
            request.getSession().setAttribute("_session_user",entity);
        }
        return result;
    }
}
