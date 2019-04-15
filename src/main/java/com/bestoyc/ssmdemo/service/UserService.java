package com.bestoyc.ssmdemo.service;

import com.bestoyc.ssmdemo.domain.User;

import java.util.List;

/**
 * @author oyc
 * @Title: UserService
 * @ProjectName ssmdemo
 * @Description: 用户服务接口
 * @date 2019/4/15 23:53
 */
public interface UserService {
    /**
     * 查询所有用户
     */
    List<User> findAll();

    /**
     * 根据ID查询用户详情
     */
    User getById(String id);

    /**
     * 根据ID删除用户
     */
    Boolean deleteById(String id);
}
