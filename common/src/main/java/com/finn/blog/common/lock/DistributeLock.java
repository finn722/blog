package com.finn.blog.common.lock;

import com.finn.blog.common.service.LockService;
import org.springframework.stereotype.Component;

@Component
public class DistributeLock {

    private String lockKey;

    private LockService lockService;

    private long lockTime;

    public DistributeLock(){}

    public DistributeLock(LockService lockService, long lockTime, String lockKey){
        this.lockKey = lockKey;
        this.lockService = lockService;
        this.lockTime = lockTime;
    }

    public boolean lock(){
        return lockService.lock(lockKey, lockTime);
    }



}
