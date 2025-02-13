package com.group12.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group12.dao.WfRuleDao;
import com.group12.entity.WfRuleEntity;
import org.springframework.stereotype.Service;
import vo.WfRuleVo;

@Service("wfRuleService")//接口名字（首字母小写）作为变量名
public class WfRuleServiceImpl  extends ServiceImpl<WfRuleDao,WfRuleEntity> implements WfRuleService  {
    @Override
    //规则的增加
    public Integer add(WfRuleEntity wfRuleEntity) {
        return baseMapper.insert(wfRuleEntity);
    }

    @Override
    //规则的删除
    public Integer delete(int id) {
        return baseMapper.deleteById(id);
    }

    @Override
    //规则的修改
    public Integer modify(WfRuleEntity updatedRule) {
        WfRuleEntity existingRule=baseMapper.selectById(updatedRule.getRuleId());
        if (existingRule!= null) {
            existingRule.setRuleName(updatedRule.getRuleName());
            existingRule.setRuleContent(updatedRule.getRuleContent());
        }
        return baseMapper.updateById(existingRule);
    }

    @Override
    //规则的查询
    //定义了一个名为page的公共方法，用于从数据库中按照指定条件分页查询WfTestEntity类型的数据，
    // 并返回一个IPage<WfTestEntity>类型的分页结果。
    public IPage<WfRuleEntity> page(WfRuleVo vo) {
        LambdaQueryWrapper<WfRuleEntity> query= Wrappers.lambdaQuery();
        //query.eq(WfRuleEntity::getRuleId, wfRuleEntity.getRuleId());//按ruleId查询
        //分页参数（默认参数）
        int curPage = 1;//默认当前页为第一页
        int limit = 10;//默认每页查10行

        if(ObjectUtils.isNotEmpty(vo.getPage())){//如果传入的页码page不为空，则更新当前页curPage为传入的页码参数值
            curPage = vo.getPage();
        }
        if(ObjectUtils.isNotEmpty(vo.getPageLine())){//如果传入的pageLine不为空，则更新limit
           limit = vo.getPageLine();
        }
        IPage<WfRuleEntity> ipage= Page.of(curPage , limit);
        //通过Page.of(page, pageline)根据处理后的页码和每页行数创建了一个分页对象ipage，
        //这个分页对象包含了分页相关的必要信息（如当前页码、每页大小等）。
        return baseMapper.selectPage(ipage,query);
        //然后调用baseMapper（通常是 MyBatis-Plus 中的 Mapper 接口实例，用于与数据库交互）的selectPage方法，
        //传入分页对象ipage和查询条件包装器query，执行数据库查询操作，并最终返回包含查询结果的分页对象，其内部包含了符合条件的WfTestEntity数据列表以及分页相关的元数据（如总记录数等）。
    }
}
