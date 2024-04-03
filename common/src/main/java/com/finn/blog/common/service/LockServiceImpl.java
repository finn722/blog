package com.finn.blog.common.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;

public class LockServiceImpl implements LockService{

    @Resource
    private Jedis jedis;

    @Override
    public boolean lock(String lockKey, long lockTime) {
        long id = Thread.currentThread().getId();
        String currentOwner = jedis.get(lockKey);
        if (currentOwner != null && currentOwner.equals(String.valueOf(id))) {
            return true;
        }
        String result = jedis.set(lockKey, String.valueOf(id),new SetParams().nx().ex(lockTime));
        
        return result != null && result.equals("ok");
    }

    public void unlock(String lockKey){
        long id = Thread.currentThread().getId();
        if(jedis.get(lockKey).equals(String.valueOf(id))){
            jedis.del(lockKey);
        }
    }
}
