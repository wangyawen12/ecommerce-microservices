package com.example.apigateway.security;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTokenService {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisTokenService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public boolean isLoginActive(String username) {
        String key = "login_user:" + username;
        String value = stringRedisTemplate.opsForValue().get(key);
        return value != null;
    }
}