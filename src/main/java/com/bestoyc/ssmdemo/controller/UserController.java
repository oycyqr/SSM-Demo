package com.bestoyc.ssmdemo.controller;

import com.bestoyc.ssmdemo.annotation.Log;
import com.bestoyc.ssmdemo.domain.User;
import com.bestoyc.ssmdemo.enums.BusinessType;
import com.bestoyc.ssmdemo.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author oyc
 * @since 2020-03-29 11:35:47
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
    @GetMapping("{id}")
    @Log(title = "通过用户id查询用户信息", businessType = BusinessType.OTHER)
    public User selectOne(@PathVariable("id") Integer id) {
        return this.userService.queryById(id);
    }


    /**
     * 列表数据
     *
     * @return 用户信息列表数据
     */
    @GetMapping("list")
    public List<User> list(Integer id) {
        return this.userService.queryAllByLimit(1, 10);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @PostMapping
    public User save(User user) {
        return this.userService.insert(user);
    }

    /**
     * 新增或修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @PutMapping
    public User saveOrUpdate(User user) {
        if (user.getId() != null) {
            return this.userService.update(user);
        } else {
            return this.userService.insert(user);
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return this.userService.deleteById(id);
    }

}
