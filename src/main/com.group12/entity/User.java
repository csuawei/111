package com.group12.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * User实体类，表示系统中的用户信息。
 */
@Entity
@Table(name = "user_s")
public class User {
    /**
     * 用户的唯一标识符，自动生成。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户的姓名。
     */
    @Column(name = "user_name")
    private String name;

    /**
     * 用户的密码，存储为加密后的形式。
     */
    @Column(name = "user_password")
    private String password;

    /**
     * 无参构造函数，用于JPA实例化对象。
     */
    public User() {}

    /**
     * 带参数的构造函数，用于创建新的用户对象。
     *
     * @param name     用户的姓名。
     * @param password 用户的密码。
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getter和Setter方法

    /**
     * 获取用户的唯一标识符。
     *
     * @return 用户的唯一标识符。
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户的唯一标识符。
     *
     * @param id 用户的唯一标识符。
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户的姓名。
     *
     * @return 用户的姓名。
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户的姓名。
     *
     * @param name 用户的姓名。
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户的密码。
     *
     * @return 用户的密码。
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户的密码。
     *
     * @param password 用户的密码。
     */
    public void setPassword(String password) {
        this.password = password;
    }
}







