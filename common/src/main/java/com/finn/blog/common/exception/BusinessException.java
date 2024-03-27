package com.finn.blog.common.exception;

import com.finn.blog.api.common.BusinessErrorEnum;

public class BusinessException extends RuntimeException{

    final BusinessErrorEnum errorEnum;

    public BusinessException(BusinessErrorEnum errorEnum){
        this.errorEnum = errorEnum;
    }


















}
