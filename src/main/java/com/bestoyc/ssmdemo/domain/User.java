package com.bestoyc.ssmdemo.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author oyc
 * @Title: User
 * @ProjectName ssmdemo
 * @Description: 用户实体类
 * @date 2019/4/15 23:38
 */
public class User {
    //用户id
    private String id;

    //用户名称
    private String name;

    //户年龄
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
