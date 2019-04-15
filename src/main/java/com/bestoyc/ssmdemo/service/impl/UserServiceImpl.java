package com.bestoyc.ssmdemo.service.impl;

import com.bestoyc.ssmdemo.domain.User;
import com.bestoyc.ssmdemo.mapper.UserMapper;
import com.bestoyc.ssmdemo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oyc
 * @Title: UserServiceImpl
 * @ProjectName ssmemo
 * @Description: 用户服务接口实现类
 * @date 2019/4/15 23:55
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询所有用户
     */
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 根据ID查询用户详情
     */
    @Override
    public User getById(String id) {
        return userMapper.getById(id);
    }

    /**
     * 根据ID删除用户
     */
    @Override
    public Boolean deleteById(String id) {
        Boolean flag = true;
        try {
            userMapper.deleteById(id);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
}
