package com.group12.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.group12.entity.WfRuleEntity;
import com.group12.service.WfRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import vo.WfRuleVo;


@RestController
@RequestMapping("wf_exam_rules/")//请求路径
public class WfRuleController {
    @Autowired//把定义的service接口注入
    private WfRuleService wfRuleService;

    @PostMapping("addRule")//导入规则
    public String addRule(@RequestBody WfRuleEntity wfRuleEntity){
        Integer i= wfRuleService.add(wfRuleEntity);
        if(i>0){
            return "success";
        }else {
            return "fail";
        }
    }
    @PostMapping("/deleteRule")
    public void deleteRule(@RequestBody int id){
        wfRuleService.delete(id);
    }
    @PostMapping("/modifyRule")
    public Integer modifyRule(@RequestBody WfRuleEntity updatedRule){
        Integer exsitingRule=wfRuleService.modify(updatedRule);
        return exsitingRule;
    }
    @PostMapping("/page")
    public IPage page(@RequestBody WfRuleVo wfRuleVo){
       // WfRuleEntity wfRuleEntity=new WfRuleEntity();
        //wfRuleEntity.setRuleId(wfRuleVo.getRuleId());
        return wfRuleService.page(wfRuleVo);

    }

}
