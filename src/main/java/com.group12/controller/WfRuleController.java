package com.group12.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.group12.entity.WfRuleEntity;
import com.group12.service.WfRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vo.WfRuleVo;


@RestController
@RequestMapping("/wf_exam_rules")//请求路径
public class WfRuleController {
    @Autowired//把定义的service接口注入
    private WfRuleService wfRuleService;

    @PostMapping("/addRule")//导入规则
    public String addRule(@RequestBody WfRuleEntity wfRuleEntity){
        Integer i= wfRuleService.add(wfRuleEntity);
        if(i>0){
            return "规则添加成功";
        }else {
            return "规则添加失败";
        }
    }
    @PostMapping("/deleteRule")
    public String deleteRule(@RequestBody int id){
        Integer i=wfRuleService.delete(id);
        if(i>0){
            return "规则删除成功";
        }else{
            return "规则删除失败";
        }

    }
    @PostMapping("/modifyRule")
    public String modifyRule(@RequestBody WfRuleEntity updatedRule){
        Integer i=wfRuleService.modify(updatedRule);
        if(i>0){
            return "规则修改成功";
        }else{
            return "规则修改失败";
        }
    }
    @PostMapping("/page")
    public IPage page(@RequestBody WfRuleVo wfRuleVo){
        //WfRuleEntity wfRuleEntity=new WfRuleEntity();
        //wfRuleEntity.setRuleId(wfRuleVo.getRuleId());
        return wfRuleService.page(wfRuleVo);

    }

}
