package com.group12.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.group12.entity.AutomaticMarkEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import vo.AutomaticMarkVo;

import java.util.List;

public interface AutomaticMarkService{
    Integer add(AutomaticMarkEntity automaticmarkEntity);
    IPage<AutomaticMarkEntity> page(AutomaticMarkVo automaticMarkVo);
    int deleteById(Long id);
    void autoMark();
    List<AutomaticMarkEntity> listByCondition(AutomaticMarkEntity condition);

}
