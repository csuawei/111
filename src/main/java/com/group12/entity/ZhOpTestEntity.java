package com.group12.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("zh_op_test")
public class ZhOpTestEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String pwd;
}