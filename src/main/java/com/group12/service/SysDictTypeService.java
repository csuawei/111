package com.group12.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group12.entity.SysDictTypeEntity;

import java.util.Map;

/**
 * 字典类型表
 *
 * @author qersoft
 * @email 626070918@qq.com
 * @date 2024-8-15
 */
public interface SysDictTypeService extends IService<SysDictTypeEntity> {

    IPage<SysDictTypeEntity> queryPage(Map<String, Object> params);
}

