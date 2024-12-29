package com.group12.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group12.entity.WfRuleEntity;
import org.apache.ibatis.annotations.Select;
import vo.WfRuleVo;


public interface WfRuleService {
    Integer add(WfRuleEntity wfRuleEntity);//增
    Integer delete(int id);//删
    Integer modify(WfRuleEntity wfRuleEntity);//改
    IPage<WfRuleEntity> page(WfRuleVo wfRuleVo);//查

}
