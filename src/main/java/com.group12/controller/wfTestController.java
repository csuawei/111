package com.group12.controller;

import com.group12.service.wfTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wfTest")
public class wfTestController {
    @Autowired
    private wfTestService wf_TestService;



}
