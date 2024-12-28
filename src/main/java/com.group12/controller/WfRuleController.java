package com.group12.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.group12.entity.WfRuleEntity;
import com.group12.service.WfRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import vo.WfRuleVo;


@RestController
@RequestMapping("/wfTest")//请求路径
public class WfRuleController {
    @Autowired//把定义的service接口注入
    private WfRuleService wfRuleService;

    @PostMapping("/insertTest")//导入试卷
    public String insertTest(@RequestBody WfRuleEntity wfRuleEntity){
        Integer i= wfRuleService.add(wfRuleEntity);
        if(i==0){
            return "sucess";
        }else {
            return "fail";
        }
    }
    public IPage list(@RequestBody WfRuleVo wfRuleVo){
        WfRuleEntity wfRuleEntity=new WfRuleEntity();
        wfRuleEntity.setRuleId(wfRuleVo.getRuleId());
        return wfRuleService.page(wfRuleEntity,wfRuleVo.getPage(),wfRuleVo.getPageLine());

    }

}
