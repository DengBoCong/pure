package com.dbc.service;

public interface RedisTemplateService {
    public <T> boolean set(String key, T value);
    public <T> T get(String key, Class<T> clazz);
}
