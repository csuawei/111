package com.group12.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group12.dao.*;
import com.group12.entity.*;
import org.springframework.stereotype.Service;

@Service("examProChooseService")
public class ExamProlmpl extends ServiceImpl<ExamProDao, ExamProEntity>
    implements ExamProService {

}
