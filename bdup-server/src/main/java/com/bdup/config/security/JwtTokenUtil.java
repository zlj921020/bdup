package com.bdup.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>
 * JwtToken工具类
 * </p>
 *
 * @author 左立俊
 * @since 2021-08-01
 */
@Component
public class JwtTokenUtil {
    private  static final String CLAIM_KEY_USERNAME="sub";
    private  static final String CLAIM_KEY_CREATED="created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;



    public String gen
}

