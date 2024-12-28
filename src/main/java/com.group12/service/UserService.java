package com.group12.service;

import com.group12.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers(); // 获取所有用户
    User getUserById(Long id); // 根据ID获取用户
    void addUser(User user); // 添加用户
    void updateUser(User user); // 更新用户
    void deleteUser(Long id); // 删除用户
}
