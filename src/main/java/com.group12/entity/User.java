package com.group12.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_s")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userId; // 用户ID
    private String userName; // 用户名
    private String userPassword; // 用户密码
    private String salt; // 盐值
    private int createBy;//修改人
}
