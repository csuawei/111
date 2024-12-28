package com.group12.controller;

import com.group12.entity.ExamProEntity;
import com.group12.service.ExamProService;
import com.group12.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/two")
public class ExamProCont {
    @Autowired
    private ExamProService examProChooseService;

    @GetMapping("/getAllPro")
    public Object getAllPro() {
        List<ExamProEntity> List_All = examProChooseService.getBaseMapper().selectList(null);
        return ResultUtil.success(List_All);

    }

    @PostMapping("/addPro")
    public Object addPro(@RequestBody ExamProEntity examProEntity) {
        int i = examProChooseService.getBaseMapper().insert(examProEntity);
        if(i == 1){
            return ResultUtil.success(null,"添加成功");
        }else{
            return ResultUtil.fail("500","添加失败");
        }
    }

}
