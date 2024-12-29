package com.group12.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group12.entity.DataDicEntity;
import com.group12.entity.DataDicSearch;
import com.group12.service.DataDicService;
import com.group12.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dataDic")
public class DatadicCont {
    @Autowired
    private DataDicService datadicService;

    @GetMapping("/getAllDic")
    public Object getAllDic() {
        List<DataDicEntity> List_All = datadicService.getBaseMapper().selectList(null);
        return ResultUtil.success(List_All);
    }

    @PostMapping("/addDic")
    public Object addDic(@RequestBody DataDicEntity dataDicEntity) {
        int i = datadicService.getBaseMapper().insert(dataDicEntity);
        if(i == 0){
            return ResultUtil.fail("503","添加数据字典失败");
        }else {
            return ResultUtil.success(null,"添加数据字典成功");
        }
    }

    @PostMapping("/updataDic")
    public Object updDic(@RequestBody DataDicEntity dataDicEntity) {
        int i = datadicService.getBaseMapper().updateById(dataDicEntity);
        if(i == 0){
            return ResultUtil.fail("504","数据字典修改失败");
        }else {
            return ResultUtil.success(null,"数据字典修改成功");
        }
    }

    @PostMapping("/delDic")
    public Object delDic(Integer id) {
        int i = datadicService.getBaseMapper().deleteById(id);
        if(i == 0){
            return ResultUtil.fail("505","数据字典删除失败");
        }else {
            return ResultUtil.success(null,"数据字典修改成功");
        }
    }

    //多条件分页查询
    @PostMapping("getDicByCon")
    public Object getDicByCon(@RequestBody DataDicSearch dataDicSearch) {
        Page<DataDicEntity> page = new Page<>(dataDicSearch.getPageNo(), dataDicSearch.getPageSize());
        QueryWrapper<DataDicEntity> queryWrapper = new QueryWrapper<>();
        if(dataDicSearch.getDicname() != null && !dataDicSearch.getDicname().equals("")){
            //根据数据字典名字模糊查询
            queryWrapper.like("dicname", dataDicSearch.getDicname());
        }
        if(dataDicSearch.getDictype() != null && !dataDicSearch.getDictype().equals("")){
            //根据数据字典类型名模糊查询
            queryWrapper.like("dictype", dataDicSearch.getDictype());
        }
        if(dataDicSearch.getId() != null && !dataDicSearch.getId().equals("")){
            //根据数据字典id精确查询
            queryWrapper.eq("id", dataDicSearch.getId());
        }
        IPage<DataDicEntity> iPage = datadicService.getBaseMapper().selectPage(page, queryWrapper);
        System.out.println(iPage.getRecords());
        return ResultUtil.success(iPage);
    }


}




