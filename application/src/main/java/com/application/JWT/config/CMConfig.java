package com.application.JWT.config;

public class CMConfig {
    public static final String HEADER_STRING = "Authorization"; // 用于认证的头字段
    public static final String TOKEN_PREFIX = "Bearer "; // Token前缀
    public static final String JWT_TOKEN_QUERY_PARAM = "token";
    public static final String AUTH = "/api/auth";
}
