package com.bestoyc.ssmdemo.controller;

import com.bestoyc.ssmdemo.domain.User;
import com.bestoyc.ssmdemo.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oyc
 * @Title: UserController
 * @ProjectName ssmemo
 * @Description: 用户控制类
 * @date 2019/4/16 0:00
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 查询所有用户
     */
    @GetMapping("list")
    public List<User> findAll() {
        return userService.findAll();
    }

    /**
     * 根据ID查询用户详情
     */
    @GetMapping("{id}")
    public User getById(@PathVariable(value = "id") String id) {
        return userService.getById(id);
    }

    /**
     * 根据ID删除用户
     */
    @Delete("{id}")
    Boolean deleteById(@PathVariable(value = "id") String id) {
        return userService.deleteById(id);
    }
}
