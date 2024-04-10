package com.application.JWT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        System.out.println("corsConfigurationSource");
//        CorsConfiguration configuration = new CorsConfiguration();
////        configuration.setAllowedOrigins(List.of("*")); // TODO: 限制为实际的前端域名
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(List.of("*"));
//        configuration.setAllowedOriginPatterns(List.of("*"));
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
    /**
     * 配置安全过滤链。
     * 该方法配置了Spring Security用于保护应用程序的过滤链。
     * 它定义了哪些请求需要认证，以及如何处理登录和登出请求。
     *
     * @param http 用于配置HttpSecurity的接口
     * @return SecurityFilterChain 安全过滤链的实例，定义了应用程序的请求如何被安全地处理
     * @throws Exception 如果配置过程中发生错误，则抛出异常
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .cors(AbstractHttpConfigurer::disable) // 根据需要启用或禁用CORS
                .csrf(AbstractHttpConfigurer::disable) // 根据需要启用或禁用CSRF
                // 配置请求授权。允许所有用户访问主页和登录页面，其他请求需要认证。
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/**").permitAll()
                        .anyRequest().authenticated()
                )
                // 配置表单登录。定义了登录页面和登录请求的处理方式。
                .formLogin((form) -> form
                        .loginProcessingUrl("/api/auth/login")
                        .permitAll()
                )
                // 配置登出功能。允许所有用户无条件登出。
                .logout(LogoutConfigurer::permitAll);

        return http.build(); // 构建并返回安全过滤链
    }

    //将用户添加到内存中
    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder passwordEncoder) {
        UserDetails user =
                User.builder()
                        .username("system")
                        .password(passwordEncoder.encode("system@ariloong"))
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}