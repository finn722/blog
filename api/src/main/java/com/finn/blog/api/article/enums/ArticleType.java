package com.finn.blog.api.article.enums;

public enum ArticleType {

    TECH(0,"tech"),
    LIFE(1,"life");

    private Integer code;
    private String desc;

    ArticleType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


}
