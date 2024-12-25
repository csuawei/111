package com.group12.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group12.dao.AutomaticMarkDao;
import com.group12.entity.AutomaticMarkEntity;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("AutomaticMarkService")
public class AutomaticMarkServiceImpl extends ServiceImpl<AutomaticMarkDao,AutomaticMarkEntity>
    implements AutomaticMarkService {

}
