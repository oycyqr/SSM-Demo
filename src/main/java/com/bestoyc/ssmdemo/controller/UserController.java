package com.bestoyc.ssmdemo.controller;

import com.bestoyc.ssmdemo.domain.User;
import com.bestoyc.ssmdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author oyc
 * @since 2020-03-26 19:12:00
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(String id) {
        return this.userService.queryById(id);
    }
	
	 
    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<User> list(String id) {
        return this.userService.queryAllByLimit(0,10);
    }

}