package com.finn.blog.common.executor;

import com.finn.blog.common.exception.BusinessException;
import com.finn.blog.common.lock.DistributeLock;
import com.finn.blog.common.service.LockService;
import org.springframework.stereotype.Component;

import com.finn.blog.api.common.Response;
import java.util.function.Supplier;

@Component
public class CommonExecutor {



    public <T> Response<T> executeWithLock(LockService lockService, String lockKey, Supplier<T> fn, String bizCall, Object... param) {
        Response<T> result = null;
        DistributeLock lock = null;

        try{
            if(lockService != null){

            }
        }catch (BusinessException ex){
            result = new Response<>(500, "Error");
        }
        return result;
    }
}
