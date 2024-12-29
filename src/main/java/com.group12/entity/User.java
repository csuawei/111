package com.group12.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user_s")
public class User {
    @TableId(type = IdType.AUTO)
    private Long userId; // 用户ID

    private String userName; // 用户名
    private String userPassword; // 用户密码

    // 无参构造函数
    public User() {}

    // 带参构造函数
    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    // Getter 和 Setter 方法
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}

