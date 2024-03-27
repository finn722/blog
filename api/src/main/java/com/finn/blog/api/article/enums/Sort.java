package com.finn.blog.api.article.enums;

public enum Sort {

    ASC("asc"),
    DESC("desc");

    private String code;

    Sort(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
