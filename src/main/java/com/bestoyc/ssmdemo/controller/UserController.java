package com.bestoyc.ssmdemo.controller;

import com.bestoyc.ssmdemo.annotation.Log;
import com.bestoyc.ssmdemo.domain.User;
import com.bestoyc.ssmdemo.enums.BusinessType;
import com.bestoyc.ssmdemo.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    @Log(title = "查询用户信息列表", businessType = BusinessType.OTHER)
    public List<User> list() {
        return this.userService.queryAllByLimit(1, 10);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @PostMapping
    @Log(title = "通过用户id查询用户信息", businessType = BusinessType.INSERT)
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
    @Log(title = "通过用户id查询用户信息", businessType = BusinessType.UPDATE)
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
    @Log(title = "通过用户id查询用户信息", businessType = BusinessType.DELETE)
    public Boolean delete(@PathVariable("id") Integer id) {
        return this.userService.deleteById(id);
    }

    /**
     * 分页查询数据
     *
     * @return 分页数据列表
     */
    @GetMapping("listByPage")
    public Page<User> listByPage(@RequestParam(defaultValue = "0") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        //关键。第一个参数代表第几页（不传代表第一页），第二个参数代表每页几条记录
        PageHelper.startPage(pageNum, pageSize);

        List<User> lists = userService.queryAll();
        //为什么要强转？就是因为我们需要获取下面输出的那些数据，比如当前第几页，共多少条等
        Page<User> pageVO = (Page<User>) lists;

        System.out.println("当前页的开始条数，从开始条数+1开始算（比如开始结束0-5，就是1-5，5-10就是6-10）：" + pageVO.getStartRow());
        System.out.println("当前页的结束条数：" + pageVO.getEndRow());
        System.out.println("当前第几页：" + pageVO.getPageNum());
        System.out.println("一共几页：" + pageVO.getPages());
        System.out.println("每页几条：" + pageVO.getPageSize());
        System.out.println("总条数：" + pageVO.getTotal());

        return pageVO;
    }
}