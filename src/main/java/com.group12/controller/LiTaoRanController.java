package com.group12.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.group12.entity.AutomaticMarkEntity;
import com.group12.service.AutomaticMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("litaoran/")
public class LiTaoRanController {

    @Autowired
    private AutomaticMarkService automaticMarkService;

    @PostMapping("insertscore")
    public String insertscore(@RequestBody AutomaticMarkEntity scores){

        Integer i = automaticMarkService.add(scores);
        if(i==0){
            return "success";
        }else{
            return "fail";
        }
    }

    @GetMapping("/page")
    public IPage<AutomaticMarkEntity> page(AutomaticMarkEntity automaticEntity,
                                           @RequestParam(defaultValue = "1") int page,
                                           @RequestParam(defaultValue = "10") int pageline) {
        return automaticMarkService.page(automaticEntity, page, pageline);
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
