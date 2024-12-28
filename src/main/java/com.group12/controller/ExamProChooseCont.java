package com.group12.controller;

import com.group12.service.ExamProChooseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("two")
public class ExamProChooseCont {
    @Autowired
    private ExamProChooseService examProChooseService;

}
