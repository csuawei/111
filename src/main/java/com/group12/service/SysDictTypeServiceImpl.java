package com.group12.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.group12.dao.SysDictTypeDao;
import com.group12.entity.SysDictTypeEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysDictTypeService")
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeDao, SysDictTypeEntity>
        implements SysDictTypeService {

    private String sysId="DanZhao";

    @Override
    public IPage<SysDictTypeEntity> queryPage(Map<String, Object> params) {//业务逻辑具体实现
        LambdaQueryWrapper<SysDictTypeEntity> query = Wrappers.lambdaQuery();
        query.like(ObjectUtils.isNotEmpty(params.get("dictName")), SysDictTypeEntity::getDictName, params.get("dictName"));
        query.eq(ObjectUtils.isNotEmpty(params.get("dictType")), SysDictTypeEntity::getDictType, params.get("dictType"));
        query.eq(ObjectUtils.isNotEmpty(params.get("status")), SysDictTypeEntity::getStatus, params.get("status"));
        query.eq(SysDictTypeEntity::getSysId, sysId);
        query.orderByDesc(SysDictTypeEntity::getDictId);

        //分页参数
        int curPage = 1;
        int limit = 10;
        if (ObjectUtils.isNotEmpty(params.get("page"))) {
            curPage = Integer.parseInt(params.get("page").toString());
        }
        if (ObjectUtils.isNotEmpty(params.get("limit"))) {
            limit = Integer.parseInt(params.get("limit").toString());
        }

        IPage<SysDictTypeEntity> page = Page.of(curPage, limit);

        return baseMapper.selectPage(page, query);
    }

}
