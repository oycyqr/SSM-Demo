package com.bestoyc.ssmdemo.domain;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author oyc
 * @since 2020-03-25 23:44:31
 */
public class User implements Serializable {
    private static final long serialVersionUID = 688756946316461306L;
    
    private String id;
    
    private String name;
    
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