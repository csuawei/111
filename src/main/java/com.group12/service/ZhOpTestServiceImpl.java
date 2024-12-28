package com.group12.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group12.dao.ZhOpTestDao;
import com.group12.entity.ZhOpTestEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

@Service("zhOpTestService")
public class ZhOpTestServiceImpl extends ServiceImpl<ZhOpTestDao, ZhOpTestEntity> implements ZhOpTestService {
    @Override
    public List<ZhOpTestEntity> findByUsername(String username) {
        LambdaQueryWrapper<ZhOpTestEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(ZhOpTestEntity::getUsername, username);
        return this.list(queryWrapper);
    }
    @Override
    public boolean deleteById(Long id) {
        // 这里可以添加自定义的删除逻辑
        // 例如，先检查是否存在，再删除
        ZhOpTestEntity entity = this.getById(id);
        if (entity != null) {
            return this.removeById(id);
        }
        return false;
    }

}