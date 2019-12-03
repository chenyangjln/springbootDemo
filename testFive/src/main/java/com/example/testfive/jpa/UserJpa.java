package com.example.testfive.jpa;


import com.example.testfive.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * 我们UserJPA继承了JpaRepository接口（SpringDataJPA提供的简单数据操作接口）、
 * JpaSpecificationExecutor（SpringDataJPA提供的复杂查询接口）、Serializable（序列化接口）。
 * 我们并不需要做其他的任何操作了，因为SpringBoot以及SpringDataJPA会为我们全部搞定，
 * SpringDataJPA内部使用了类代理的方式让继承了它接口的子接口都以spring管理的Bean的形式存在，
 * 也就是说我们可以直接使用@Autowired注解在spring管理bean使用
 * @author Alex
 * @create 2019-12-02 19:35
 */
public interface UserJpa extends
        JpaRepository<UserEntity,Long> ,
        JpaSpecificationExecutor <UserEntity>,
        Serializable {
}
