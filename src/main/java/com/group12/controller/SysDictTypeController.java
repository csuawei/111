package com.group12.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.group12.entity.SysDictTypeEntity;
import com.group12.service.SysDictTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


/**
 * 字典类型表
 *
 * @author qersoft
 * @date 2024-3-15
 */
@Slf4j
@RestController
@RequestMapping("backend/dictType")
public class SysDictTypeController  {

    @Autowired
    private SysDictTypeService sysDictTypeService;

    /**
     * 列表
     */
    @PostMapping("/list")
    public IPage list(@RequestBody Map<String, Object> params) {
        IPage<SysDictTypeEntity> page = sysDictTypeService.queryPage(params);
        return page;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{dictId}")
    public SysDictTypeEntity info(@PathVariable("dictId") Long dictId) {
        SysDictTypeEntity sysDictType = sysDictTypeService.getById(dictId);
        return sysDictType;
    }



}
