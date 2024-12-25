package com.group12.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group12.dao.ZhOpTestDao;
import com.group12.entity.ZhOpTestEntity;
import org.springframework.stereotype.Service;

@Service("zhOpTestService")
public class ZhOpTestServiceImpl extends ServiceImpl<ZhOpTestDao, ZhOpTestEntity> implements ZhOpTestService {
}