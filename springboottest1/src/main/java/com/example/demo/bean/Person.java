package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 *  @ConfigurationProperties : 告诉spring boot将本类中的所有属性和配置文件中相关的属性进行绑定
 *      prefix = "person": 告诉配置文件中是哪一个下面的所有属性进行一一映射
 *   只有这个组件是容器中的组件，才能使用容器中提供的@ConfigurationProperties功能
 *   @ConfigurationProperties(prefix = "person") 默认从全局配置文件中获取值
 *
 * @author Alex
 * @create 2019-12-18 16:35
 */
//@PropertySource(value = {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {

    /**
     * <bean class="Person">
     *      <property name="lastName" value="1:字面量;2:${key}从环境变量/配置文件中获取值;3:#{SpEL}spring表达式;"></property>
     * </bean>
     */
//    @Value("${person.last-name}")
//    @Email
//    lastName必须时邮箱格式
    private String LastName;

//    @Value("#{11*2}")
    private Integer age;

//    @Value("true")
    private Boolean boss;
    private Date birth;

    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "LastName='" + LastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
