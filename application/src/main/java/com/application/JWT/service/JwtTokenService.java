
package com.application.JWT.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * JWT令牌服务类，用于生成和解析JWT令牌。
 */
@Service
public class JwtTokenService {

    // 用于签名JWT令牌的密钥
    @Value("${jwt.TokenSigningKey}")
    public static String SECRET_KEY;

    // 令牌的过期时间（1小时）
    @Value("${jwt.ExpirationTime}")
    private static long EXPIRATION_TIME;

    /**
     * 生成JWT令牌。
     *
     * @param username 令牌的主题，即用户名
     * @return 生成的JWT令牌字符串
     */
    public String generateToken(String username) {
        // 使用Jwts.builder()创建JWT令牌构建器
        return Jwts.builder()
                // 设置令牌的主题为用户名
                .setSubject(username)
                // 设置令牌的过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                // 使用密钥和签名算法对令牌进行签名
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                // 将构建好的令牌紧凑型地表示出来
                .compact();
    }
}