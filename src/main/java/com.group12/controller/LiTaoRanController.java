package com.group12.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.group12.entity.AutomaticMarkEntity;
import com.group12.service.AutomaticMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vo.AutomaticMarkVo;

import java.util.List;

@RestController
@RequestMapping("litaoran/")
public class LiTaoRanController {

    @Autowired
    private AutomaticMarkService automaticMarkService;

    @PostMapping("insertquestion")
    public String insertquestion(@RequestBody AutomaticMarkEntity questions){

        Integer i = automaticMarkService.add(questions);
        if(i==0){
            return "success";
        }else{
            return "fail";
        }
    }

    @GetMapping("page")
    public IPage<AutomaticMarkEntity> page(AutomaticMarkVo automaticMarkVo,
                                           @RequestParam(defaultValue = "1") int page,
                                           @RequestParam(defaultValue = "10") int pageline) {
        return automaticMarkService.page(automaticMarkVo);
    }

    @GetMapping("/listByCondition")
    public List<AutomaticMarkEntity> listByCondition(AutomaticMarkEntity condition) {
        return automaticMarkService.listByCondition(condition);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable Long id) {
        return automaticMarkService.deleteById(id);
    }

    @PostMapping("/autoMark")
    public void autoMark() {
        automaticMarkService.autoMark();
    }

}
