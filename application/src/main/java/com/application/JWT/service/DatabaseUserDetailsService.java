package com.application.JWT.service;

import com.application.JWT.config.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class DatabaseUserDetailsService {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public DatabaseUserDetailsService(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        try {
//            // 查询数据库，获取用户信息及其角色
//            return jdbcTemplate.queryForObject(
//                    "SELECT username, password, role FROM users WHERE username = ?",
//                    (rs, _) -> {
//                        String username1 = rs.getString("username");
//                        String password = rs.getString("password");
//                        byte role = rs.getByte("role");
//                        // 创建并返回一个UserDetails对象，这里假设每个用户都只有一个角色
//                        return User.builder()
//                                .username(username1)
//                                .password(password) // 这里的密码应该是数据库中已经加密过的
//                                .roles(String.valueOf(role)) // 角色的名称不应该有"ROLE_"前缀，Spring Security会自动添加
//                                .build();
//                    });
//        } catch (Exception e) {
//            // 如果用户找不到，抛出UsernameNotFoundException异常
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }
}
