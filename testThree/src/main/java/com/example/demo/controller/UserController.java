package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Alex
 * @create 2019-12-02 19:28
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserJpa userJpa;

    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserEntity> list() {
        return userJpa.findAll();
    }

    /**
     * 添加、更新用户的方法
     * userJPA.save方法可以执行添加也可以执行更新，如果需要执行持久化的实体存在主键值则更新数据，如果不存在则添加数据
     * @param
     * @return
     */
    @RequestMapping(value = "/save" , method = RequestMethod.GET)
    public UserEntity save(@RequestParam(value = "name") String name,
                           @RequestParam(value = "age") int age,
                           @RequestParam(value = "address") String adress){
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setAge(age);
        user.setAddress(adress);
        return userJpa.save(user);
    }

    @RequestMapping(value = "/saveex" , method = RequestMethod.GET)
    public UserEntity saveex(UserEntity entity){
        return userJpa.save(entity);
    }

    /**
     * 删除用户的方法
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete" , method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        userJpa.deleteById(id);
        return userJpa.findAll();
    }

}
