package com.group12.controller;

import com.group12.entity.User;
import com.group12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping // 获取所有用户
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}") // 根据ID获取用户
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping // 添加用户
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/{id}") // 更新用户
    public void updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setUserName(userDetails.getUserName());
            user.setUserPassword(userDetails.getUserPassword());
            userService.updateUser(user);
        }
    }

    @DeleteMapping("/{id}") // 删除用户
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}