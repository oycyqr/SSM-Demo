package com.bestoyc.ssmdemo.mapper;

import com.bestoyc.ssmdemo.domain.SysOperLog;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 操作日志记录(SysOperLog)表数据库访问层
 *
 * @author oyc
 * @since 2020-04-01 11:36:04
 */
public interface SysOperLogMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param operId 主键
     * @return 实例对象
     */
    SysOperLog queryById(Integer operId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysOperLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysOperLog 实例对象
     * @return 对象列表
     */
    List<SysOperLog> queryAll(SysOperLog sysOperLog);

    /**
     * 新增数据
     *
     * @param sysOperLog 实例对象
     * @return 影响行数
     */
    int insert(SysOperLog sysOperLog);

    /**
     * 修改数据
     *
     * @param sysOperLog 实例对象
     * @return 影响行数
     */
    int update(SysOperLog sysOperLog);

    /**
     * 通过主键删除数据
     *
     * @param operId 主键
     * @return 影响行数
     */
    int deleteById(Integer operId);

}