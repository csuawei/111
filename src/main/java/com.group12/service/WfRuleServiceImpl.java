package com.group12.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group12.dao.WfRuleDao;
import com.group12.entity.WfRuleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("wfRuleService")//接口名字（首字母小写）作为变量名
public class WfRuleServiceImpl  extends ServiceImpl<WfRuleDao,WfRuleEntity> implements WfRuleService  {

    @Override
    public WfRuleEntity findExamRuleById(int ruleId) {
        return null;
    }

    @Override
    //规则的增加
    public Integer add(WfRuleEntity wfRuleEntity) {
        return baseMapper.insert(wfRuleEntity);
    }

    //规则的删除
    public Integer delete(WfRuleEntity wfRuleEntity) {
        return baseMapper.insert(wfRuleEntity);
    }

    @Override
    //规则的修改
    @Mapper
    public Integer modify(WfRuleEntity updatedRule) {
        WfRuleEntity existingRule=findExamRuleById(updatedRule.getRuleId());
       // WfRuleEntity existingRule = Repository.findById(updatedRule.getRuleId()).orElse(null);
        if (existingRule!= null) {
            existingRule.setRuleName(updatedRule.getRuleName());
            existingRule.setRuleContent(updatedRule.getRuleContent());
        }
        return baseMapper.insert(existingRule);
    }

    //规则的修改

    @Override
    //规则的查询
    //定义了一个名为page的公共方法，用于从数据库中按照指定条件分页查询WfTestEntity类型的数据，
    // 并返回一个IPage<WfTestEntity>类型的分页结果。
    public IPage<WfRuleEntity> page(WfRuleEntity wfRuleEntity, int page, int pageline) {
        LambdaQueryWrapper<WfRuleEntity> query= Wrappers.lambdaQuery();
        query.eq(WfRuleEntity::getRuleId, wfRuleEntity.getRuleId());//按ruleId查询
        //分页参数
        if(page==0){//如果传入的页码为 0，则将其设置为 1，确保页码从 1 开始计数
            page=1;
        }
        if(pageline==0){//如果传入的每页行数为 0，则将其默认设置为 10，
            pageline=10;//意味着如果调用者没有指定每页显示多少条数据时，默认每页查询 10 条数据。
        }
        IPage<WfRuleEntity> ipage= Page.of(page,pageline);
        //通过Page.of(page, pageline)根据处理后的页码和每页行数创建了一个分页对象ipage，
        //这个分页对象包含了分页相关的必要信息（如当前页码、每页大小等）。
        return baseMapper.selectPage(ipage,query);
        //然后调用baseMapper（通常是 MyBatis-Plus 中的 Mapper 接口实例，用于与数据库交互）的selectPage方法，
        //传入分页对象ipage和查询条件包装器query，执行数据库查询操作，并最终返回包含查询结果的分页对象，其内部包含了符合条件的WfTestEntity数据列表以及分页相关的元数据（如总记录数等）。
    }
}
