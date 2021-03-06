package com.bestoyc.ssmdemo.service;

import com.bestoyc.ssmdemo.domain.SysOperLog;
import java.util.List;

/**
 * 操作日志记录(SysOperLog)表服务接口
 *
 * @author oyc
 * @since 2020-04-01 11:36:04
 */
public interface SysOperLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param operId 主键
     * @return 实例对象
     */
    SysOperLog queryById(Integer operId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysOperLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysOperLog 实例对象
     * @return 实例对象
     */
    SysOperLog insert(SysOperLog sysOperLog);

    /**
     * 修改数据
     *
     * @param sysOperLog 实例对象
     * @return 实例对象
     */
    SysOperLog update(SysOperLog sysOperLog);

    /**
     * 通过主键删除数据
     *
     * @param operId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer operId);

}
