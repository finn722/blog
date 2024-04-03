package com.finn.blog.api.common;

public enum BusinessErrorEnum {

    SUCCESS(0,"Success"),
    UNKNOWN_ERROR(100000,"Unknown Error"),
    SYSTEM_ERROR(100001,"System Error"),
    PARAM_ERROR(100002,"Param Error"),
    CONNECTION_ERROR(100003,"Connection Error"),
    DATA_FORMAT_ERROR(100004,"Data Format Error"),
    DATA_EXIST(100005,"Data Exist"),

    ;

    private final int code;

    private final String message;

    BusinessErrorEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }


}
