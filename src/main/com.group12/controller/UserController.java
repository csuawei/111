package com.group12.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group12.entity.User;
import com.group12.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户管理控制器
 *
 * @author group12
 * @date 2024-12-25
 */
@Slf4j
@RestController
@RequestMapping("backend/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @PostMapping("/list")
    public IPage<User> list(@RequestBody Map<String, Object> params) {
        Page<User> page = new Page<>();
        IPage<User> resultPage = userService.queryPage(page, params);
        return resultPage;
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{name}")
    public User info(@PathVariable("name") String name) {
        User user = userService.getUserByName(name);
        return user;
    }

    /**
     * 注册新用户
     */
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return createdUser;
    }

    /**
     * 更新用户
     */
    @PutMapping("/update")
    public User update(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return updatedUser;
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password) {
        if (userService.login(name, password)) {
            return "登录成功";
        } else {
            return "无效的凭据";
        }
    }
}











