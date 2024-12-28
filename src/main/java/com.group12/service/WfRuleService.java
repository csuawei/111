package com.group12.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group12.entity.WfRuleEntity;
import org.apache.ibatis.annotations.Select;


public interface WfRuleService {
    @Select("SELECT * FROM exam_rule WHERE rule_id = #{ruleId}")
    WfRuleEntity findExamRuleById(int ruleId);
    Integer add(WfRuleEntity wfRuleEntity);//增
    Integer delete(WfRuleEntity wfRuleEntity);//删
    Integer modify(WfRuleEntity wfRuleEntity);//改
    IPage<WfRuleEntity> page(WfRuleEntity wfRuleEntity,int page,int pageline);//查

}
