package com.group12.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_dict_type")
public class SysDictTypeEntity {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String code;
    private String description;
}
