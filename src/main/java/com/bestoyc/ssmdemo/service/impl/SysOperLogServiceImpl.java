package com.bestoyc.ssmdemo.service.impl;

import com.bestoyc.ssmdemo.domain.SysOperLog;
import com.bestoyc.ssmdemo.mapper.SysOperLogMapper;
import com.bestoyc.ssmdemo.service.SysOperLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作日志记录(SysOperLog)表服务实现类
 *
 * @author oyc
 * @since 2020-04-01 11:36:04
 */
@Service("sysOperLogService")
public class SysOperLogServiceImpl implements SysOperLogService {
    @Resource
    private SysOperLogMapper sysOperLogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param operId 主键
     * @return 实例对象
     */
    @Override
    public SysOperLog queryById(Integer operId) {
        return this.sysOperLogMapper.queryById(operId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysOperLog> queryAllByLimit(int offset, int limit) {
        return this.sysOperLogMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysOperLog 实例对象
     * @return 实例对象
     */
    @Override
    public SysOperLog insert(SysOperLog sysOperLog) {
        this.sysOperLogMapper.insert(sysOperLog);
        return sysOperLog;
    }

    /**
     * 修改数据
     *
     * @param sysOperLog 实例对象
     * @return 实例对象
     */
    @Override
    public SysOperLog update(SysOperLog sysOperLog) {
        this.sysOperLogMapper.update(sysOperLog);
        return this.queryById(sysOperLog.getOperId());
    }

    /**
     * 通过主键删除数据
     *
     * @param operId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer operId) {
        return this.sysOperLogMapper.deleteById(operId) > 0;
    }
}