package com.finn.blog.common.executor;

import com.finn.blog.api.common.BusinessErrorEnum;
import com.finn.blog.common.exception.BusinessException;
import com.finn.blog.common.lock.DistributeLock;
import com.finn.blog.common.service.LockService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.finn.blog.api.common.Response;
import org.springframework.util.StopWatch;

import java.util.function.Supplier;

@Component
@Slf4j
public class CommonExecutor {

    private static final Logger logger = LoggerFactory.getLogger(CommonExecutor.class);

    public <T> Response<T> execute(Supplier<T> fn,String bizCall,Object...params){
        return executeWithLock(null,null,fn,bizCall,params);
    }

    public <T> Response<T> executeWithLock(LockService lockService, String lockKey, Supplier<T> fn, String bizCall, Object... param) {
        DistributeLock lock = null;
        boolean lockResult = false;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(bizCall + "start");
        Response<T> response ;
        try{
            logger.info("BizCall={}, params={}", bizCall, param);
            if(lockService != null){
                lock = new DistributeLock(lockService,3000, lockKey);
                lockResult = lock.lock();
            }
            response = new Response<>(BusinessErrorEnum.SUCCESS.getCode(), BusinessErrorEnum.SUCCESS.getMessage());
            response.setData(fn.get());
        }catch (BusinessException ex){
            log.warn("BizCall={} for BusinessException occurred,param:{}  ", bizCall, param, ex);
            response = new Response<>(ex.getCode(), ex.getMessage());
        }catch (Exception ex){
            logger.warn("BizCall={} for Exception occurred, param: {}", bizCall, param, ex);
            throw new BusinessException(BusinessErrorEnum.SYSTEM_ERROR);
        } finally {
            if(lock != null && lockResult){
                lock.unlock();
            }
        }
        stopWatch.stop();
        log.info("BizCall={}, param={} cost time={}ms", bizCall, param,stopWatch.getTotalTimeMillis());
        return response;
    }
}
