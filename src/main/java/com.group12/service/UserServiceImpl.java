package com.group12.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group12.dao.UserDao;
import com.group12.entity.User;
import com.group12.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public List<User> getAllUsers() {
        return list();
    }

    @Override
    public User getUserById(Long id) {
        return getById(id);
    }

    @Override
    public void addUser(User user) {
        save(user);
    }

    @Override
    public void updateUser(User user) {
        updateById(user);
    }

    @Override
    public void deleteUser(Long id) {
        removeById(id);
    }
}