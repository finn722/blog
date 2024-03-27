package com.finn.blog.common.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class LockServiceImpl implements LockService{

    private Jedis jedis;

    private String lockKey;

    private boolean locked;

//    @Override
//    public boolean lock(String lockKey, long lockTime) {
//        long id = Thread.currentThread().getId();
//        jedis.setex(lockKey, (int) lockTime, String.valueOf(id));
//        return true;
//
//
//    }

    @Override
    public boolean lock(String lockKey, long lockTime) {
        long id = Thread.currentThread().getId();
        String currentOwner = jedis.get(lockKey);
        if (currentOwner != null && currentOwner.equals(String.valueOf(id))) {
            return true;
        }
        
        return (jedis.set(lockKey, String.valueOf(id),new SetParams().nx().ex(lockTime))) != null;
    }

    public void unlock(String lockKey){
        long id = Thread.currentThread().getId();
        if(jedis.get(lockKey).equals(String.valueOf(id))){
            jedis.del(lockKey);
        }
    }
}
