package com.finn.blog.id.exception;

import com.finn.blog.api.common.BusinessErrorEnum;

public class BusinessException extends RuntimeException{


    final BusinessErrorEnum errorEnum;

    public BusinessException(BusinessErrorEnum errorEnum){
        this.errorEnum = errorEnum;
    }


    public int getCode(){
        return this.errorEnum.getCode();
    }
    public String getMessage(){
        return this.errorEnum.getMessage();
    }
}
