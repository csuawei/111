package com.group12.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group12.entity.User;

public interface UserService extends IService<User> {
    // 自动实现基本的CRUD操作

    boolean saveWithEncryption(User entity);

    boolean checkPassword(String rawPassword, User user);
}