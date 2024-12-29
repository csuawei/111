package com.group12.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group12.dao.UserDao;
import com.group12.entity.User;
import com.group12.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    private static final int SALT_LENGTH = 16; // 盐长度
    private static final String HASH_ALGORITHM = "SHA-256"; // 哈希算法

    @Autowired
    private UserDao userDao;

    /**
     * 生成随机盐值
     */
    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    /**
     * 将字节数组转换为十六进制字符串
     */
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * 使用指定盐值对密码进行哈希处理
     */
    private String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        digest.reset();
        digest.update(salt);
        byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashedBytes);
    }

    /**
     * 验证密码是否匹配
     */
    private boolean verifyPassword(String inputPassword, String storedHash, byte[] salt) throws NoSuchAlgorithmException {
        String inputHash = hashPassword(inputPassword, salt);
        return inputHash.equals(storedHash);
    }

    /**
     * 加密并保存用户信息
     */
    @Override
    public boolean saveWithEncryption(User entity) {
        try {
            byte[] salt = generateSalt(); // 生成盐值
            String saltHex = bytesToHex(salt); // 将盐值转换为十六进制字符串
            String encryptedPassword = hashPassword(entity.getUserPassword(), salt); // 加密密码
            entity.setUserPassword(encryptedPassword); // 设置加密后的密码
            entity.setSalt(saltHex); // 设置盐值
            boolean saved = super.save(entity); // 保存用户信息
            if (!saved) {
                log.error("Failed to save user with encryption");
            }
            return saved;
        } catch (NoSuchAlgorithmException e) {
            log.error("Error hashing password", e); // 记录错误日志
            throw new RuntimeException("Error hashing password", e); // 抛出运行时异常
        }
    }

    /**
     * 验证用户密码
     */
    @Override
    public boolean checkPassword(String rawPassword, User user) {
        try {
            byte[] salt = hexToBytes(user.getSalt()); // 将十六进制字符串转换为字节数组
            return verifyPassword(rawPassword, user.getUserPassword(), salt); // 验证密码
        } catch (NoSuchAlgorithmException e) {
            log.error("Error verifying password", e); // 记录错误日志
            throw new RuntimeException("Error verifying password", e); // 抛出运行时异常
        }
    }

    private byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i+1), 16));
        }
        return data;
    }
}