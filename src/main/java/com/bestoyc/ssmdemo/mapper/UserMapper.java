package com.bestoyc.ssmdemo.mapper;

import com.bestoyc.ssmdemo.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author oyc
 * @Title: UserMapper
 * @ProjectName ssmdemo
 * @Description: UserMapper
 * @date 2019/4/15 23:43
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 根据ID查询用户详情
     */
    @Select("select * from user where id = #{id}")
    User getById(String id);

    /**
     * 根据ID删除用户
     */
    @Delete("delete from user where id = #{id}")
    void deleteById(String id);
}
