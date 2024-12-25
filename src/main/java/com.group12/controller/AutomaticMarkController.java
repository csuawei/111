package com.group12.controller;

import com.group12.service.AutomaticMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AutomaticMark")

public class AutomaticMarkController {
    @Autowired
    private AutomaticMarkService AutomaticMarkService;

}
