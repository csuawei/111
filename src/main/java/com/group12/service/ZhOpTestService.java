package com.group12.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group12.entity.ZhOpTestEntity;

public interface ZhOpTestService extends IService<ZhOpTestEntity> {
    List<ZhOpTestEntity> findByUsername(String username);
    boolean deleteById(Long id);
}

