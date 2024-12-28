package com.group12.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
@Data //lombok框架，不需要再写set、get方法
@TableName("wf_test")//指定与实体类绑定的数据库表名
public class WfTestEntity {//定义实体类
    @TableId(type=IdType.AUTO)//自增长
    private int testId;
    private String subject;
    private int rule;
}
