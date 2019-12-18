package com.example.demo.controller;

import com.example.demo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex
 * @create 2019-12-01 16:30
 */
@RestController
@RequestMapping
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello Wolrd!";
    }

    @RequestMapping(value = "/config" , method = RequestMethod.GET)
    public void config() {
        System.out.println(person);
    }
}
