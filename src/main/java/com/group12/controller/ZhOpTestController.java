package com.group12.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group12.entity.ZhOpTestEntity;
import com.group12.service.ZhOpTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zhOpTest")
public class ZhOpTestController {

    @Autowired
    private ZhOpTestService zhOpTestService;

    @GetMapping("/list")
    public List<ZhOpTestEntity> list() {
        return zhOpTestService.list();
    }

    @PostMapping("/save")
    public boolean save(@RequestBody ZhOpTestEntity zhOpTestEntity) {
        return zhOpTestService.save(zhOpTestEntity);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody ZhOpTestEntity zhOpTestEntity) {
        return zhOpTestService.updateById(zhOpTestEntity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return zhOpTestService.removeById(id);
    }

    @GetMapping("/page")
    public IPage<ZhOpTestEntity> page(@RequestParam int page, @RequestParam int size) {
        return zhOpTestService.page(new Page<>(page, size));
    }
}