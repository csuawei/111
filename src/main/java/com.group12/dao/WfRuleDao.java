package com.group12.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group12.entity.WfRuleEntity;
import org.apache.ibatis.annotations.Mapper;
@Mapper//表示这个接口是mybatis提供的
public interface WfRuleDao extends BaseMapper<WfRuleEntity>{

    int insert(WfRuleEntity wfRuleEntity);
}
