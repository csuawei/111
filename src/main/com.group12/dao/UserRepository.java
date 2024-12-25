package com.group12.dao;

import com.group12.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository接口继承自JpaRepository，用于对User实体进行数据库操作。
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名查找用户的方法。
     *
     * @param name 要查找的用户的用户名。
     * @return 如果找到匹配的用户，则返回该User对象；否则返回null。
     */
    User findByName(String name);
}










