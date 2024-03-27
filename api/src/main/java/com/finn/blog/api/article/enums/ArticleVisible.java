package com.finn.blog.api.article.enums;

public enum ArticleVisible {

    PUBLIC(0, "public"),

    PRIVATE(1, "private"),


    ;
    private int code;

    private String desc;

    ArticleVisible(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

}
