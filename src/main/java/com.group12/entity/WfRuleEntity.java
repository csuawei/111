package com.group12.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("wf_exam_rules")
public class WfRuleEntity {
    @TableId(type= IdType.AUTO)//自增长
    private int ruleId;
    private String ruleContent;
    private String ruleName;
}
