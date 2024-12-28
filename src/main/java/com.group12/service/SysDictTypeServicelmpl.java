package com.group12.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group12.dao.*;
import com.group12.entity.*;
import org.springframework.stereotype.Service;

@Service("sysDictTypeService")
public class SysDictTypeServicelmpl extends ServiceImpl<SystemDictTypeDao,SysDictTypeEntity>
        implements SysDictTypeService{

}

