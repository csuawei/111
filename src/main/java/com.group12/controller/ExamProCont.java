package com.group12.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group12.entity.ExamProEntity;
import com.group12.entity.ExamProSearch;
import com.group12.service.ExamProService;
import com.group12.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/examPro")
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

    @PostMapping("/updataPro")
    public Object updataPro(@RequestBody ExamProEntity examProEntity) {
        int i = examProChooseService.getBaseMapper().updateById(examProEntity);
        if(i == 1){
            return ResultUtil.success(null,"更新成功");
        }else {
            return ResultUtil.fail("501","更新失败");
        }
    }

    @PostMapping("/delPro")
    public Object delPro(Integer id) {
        int i = examProChooseService.getBaseMapper().deleteById(id);
        if(i == 1){
            return ResultUtil.success(null,"删除成功");
        }else {
            return ResultUtil.fail("502","删除失败");
        }
    }

    //多条件分页查询
    @PostMapping("/getProByCon")
    public Object getProByCon(@RequestBody ExamProSearch examProSearch) {
        Page<ExamProEntity> page = new Page<>(examProSearch.getPageNo(),examProSearch.getPageSize());
        QueryWrapper<ExamProEntity> queryWrapper = new QueryWrapper<>();
        if(examProSearch.getProbody() != null && !examProSearch.getProbody().equals("")){
            //根据题干模糊查询
            queryWrapper.like("probody",examProSearch.getProbody());
        }
        if(examProSearch.getId() != null && !examProSearch.getId().equals("")){
            //根据id精确查询
            queryWrapper.eq("id",examProSearch.getId());
        }
        if(examProSearch.getDiff() != null && !examProSearch.getDiff().equals("")){
            //根据难易度精确查询
            queryWrapper.eq("diff",examProSearch.getDiff());
        }
        if(examProSearch.getCourse() != null && !examProSearch.getCourse().equals("")){
            //根据课程模糊查询
            queryWrapper.like("course",examProSearch.getCourse());
        }
        if(examProSearch.getKnowpoint() != null && !examProSearch.getKnowpoint().equals("")){
            //根据知识点模糊查询
            queryWrapper.like("knowpoint",examProSearch.getKnowpoint());
        }
        if(examProSearch.getProtype() != null && !examProSearch.getProtype().equals("")){
            //根据题目类型查询
            queryWrapper.like("protype",examProSearch.getProtype());
        }
        IPage<ExamProEntity> iPage = examProChooseService.page(page, queryWrapper);
        System.out.println("总记录数："+iPage.getRecords());
        return ResultUtil.success(iPage);
    }
}
