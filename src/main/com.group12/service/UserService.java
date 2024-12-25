package com.group12.service;

import com.group12.dao.UserRepository;
import com.group12.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * UserService类，提供用户相关的业务逻辑操作。
 */
@Service
public class UserService {

    /**
     * 自动装配UserRepository以注入到服务中。
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * 自动装配BCryptPasswordEncoder以用于密码加密。
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 创建新用户的业务逻辑方法。
     *
     * @param user 包含要创建的用户详细信息的User对象。
     * @return 创建后的User对象。
     */
    public User createUser(User user) {
        // 对用户密码进行加密
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // 保存用户到数据库并返回创建后的用户对象
        return userRepository.save(user);
    }

    /**
     * 分页查询用户的业务逻辑方法。
     *
     * @param page   分页对象。
     * @param params 查询参数。
     * @return 分页结果。
     */
    public Page<User> queryPage(Page<User> page, Map<String, Object> params) {
        // 根据查询参数进行分页查询
        return userRepository.findAll(page);
    }

    /**
     * 根据用户名获取用户的业务逻辑方法。
     *
     * @param name 要检索的用户的用户名。
     * @return 如果找到匹配的用户，则返回该User对象；否则返回null。
     */
    public User getUserByName(String name) {
        // 通过用户名从数据库中查找用户
        return userRepository.findByName(name);
    }

    /**
     * 更新现有用户的业务逻辑方法。
     *
     * @param user 包含更新信息的User对象。
     * @return 更新后的User对象。
     * @throws RuntimeException 如果用户不存在则抛出异常。
     */
    public User updateUser(User user) {
        // 检查用户ID是否存在且用户存在
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            // 如果密码不为空，则对密码进行加密
            if (user.getPassword() != null) {
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            }
            // 保存更新后的用户到数据库并返回更新后的用户对象
            return userRepository.save(user);
        }
        // 如果用户不存在，则抛出异常
        throw new RuntimeException("用户不存在");
    }

    /**
     * 删除用户的业务逻辑方法。
     *
     * @param id 要删除的用户的ID。
     * @throws RuntimeException 如果用户不存在则抛出异常。
     */
    public void deleteUser(Long id) {
        // 检查用户ID是否存在
        if (userRepository.existsById(id)) {
            // 从数据库中删除用户
            userRepository.deleteById(id);
        } else {
            // 如果用户不存在，则抛出异常
            throw new RuntimeException("用户不存在");
        }
    }

    /**
     * 用户登录验证的业务逻辑方法。
     *
     * @param name     尝试登录的用户的用户名。
     * @param password 尝试登录的用户的密码。
     * @return 如果登录成功，则返回true；否则返回false。
     */
    public boolean login(String name, String password) {
        // 通过用户名从数据库中查找用户
        User user = userRepository.findByName(name);
        // 检查用户是否存在且密码匹配
        if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return true;
        }
        return false;
    }
}









