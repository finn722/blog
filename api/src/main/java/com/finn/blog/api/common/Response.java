package com.finn.blog.api.common;

import java.io.Serializable;

public class Response<T> implements Serializable {


    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    private T data;

    public Response() {
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> Response<T> ok(T data){
        Response<T> response = new Response<>();
        response.setCode(BusinessErrorEnum.SUCCESS.getCode());
        response.setMessage(BusinessErrorEnum.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }


    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
