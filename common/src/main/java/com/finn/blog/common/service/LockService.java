package com.finn.blog.common.service;

public interface LockService {
    boolean lock(String lockKey, long lockTime);
    void unlock(String lockKey);
}
