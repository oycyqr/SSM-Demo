package com.bestoyc.ssmdemo.controller;

import com.bestoyc.ssmdemo.domain.SysOperLog;
import com.bestoyc.ssmdemo.service.SysOperLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作日志记录(SysOperLog)表控制层
 *
 * @author oyc
 * @since 2020-04-01 11:36:04
 */
@RestController
@RequestMapping("sysOperLog")
public class SysOperLogController {
    /**
     * 服务对象
     */
    @Resource
    private SysOperLogService sysOperLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysOperLog selectOne(Integer id) {
        return this.sysOperLogService.queryById(id);
    }
    
    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<SysOperLog> list(Integer id) {
        return this.sysOperLogService.queryAllByLimit(1,10);
    }

}