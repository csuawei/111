package com.group12.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group12.dao.*;
import com.group12.entity.*;
import org.springframework.stereotype.Service;

@Service("datadicService")//首字母小写
public class DataDiclmpl extends ServiceImpl<DataDicDao, DataDicEntity>
        implements DataDicService {
}

