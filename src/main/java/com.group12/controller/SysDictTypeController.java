package com.group12.controller;

import com.group12.service.SysDictTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("one")
public class SysDictTypeController {
    @Autowired
    private SysDictTypeService sysDictTypeService;
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}




