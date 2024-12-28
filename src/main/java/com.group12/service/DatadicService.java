package com.group12.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group12.entity.AutomaticMarkEntity;
import com.group12.entity.DatadicEntity;

public interface DatadicService extends IService<DatadicEntity> {
    //此处定义方法
    Integer add(DatadicEntity sysDictTypeEntity);
}
