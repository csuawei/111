package com.group12.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group12.entity.User;
import com.group12.service.UserService;
import com.group12.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取所有用户
     */
    @GetMapping("/getAllUsers")
    public Object getAllUsers() {
        List<User> userList = userService.list(); // 获取所有用户列表
        return ResultUtil.success(userList);
    }

    /**
     * 添加新用户
     */
    @PostMapping("/addUser")
    public Object addUser(@RequestBody User user) {
        boolean saved = userService.saveWithEncryption(user); // 加密并保存用户信息
        if (saved) {
            return ResultUtil.success(null, "添加成功");
        } else {
            return ResultUtil.fail("500", "添加失败");
        }
    }

    /**
     * 更新用户信息
     */
    @PostMapping("/updateUser")
    public Object updateUser(@RequestBody User userDetails) {
        boolean updated = userService.updateById(userDetails); // 更新用户信息
        if (updated) {
            return ResultUtil.success(null, "更新成功");
        } else {
            return ResultUtil.fail("501", "更新失败");
        }
    }

    /**
     * 删除用户
     */
    @PostMapping("/deleteUser")
    public Object deleteUser(@RequestParam Long id) {
        boolean deleted = userService.removeById(id); // 根据ID删除用户
        if (deleted) {
            return ResultUtil.success(null, "删除成功");
        } else {
            return ResultUtil.fail("502", "删除失败");
        }
    }

    /**
     * 用户登录验证
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String userName, @RequestParam String userPassword) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        User user = userService.getOne(queryWrapper); // 根据用户名查询用户
        Map<String, Object> result = new HashMap<>();
        if (user != null && userService.checkPassword(userPassword, user)) { // 验证密码
            result.put("code", 200);
            result.put("message", "登录成功");
        } else {
            result.put("code", 401);
            result.put("message", "用户名或密码错误");
        }
        return result; // 返回结果
    }
}