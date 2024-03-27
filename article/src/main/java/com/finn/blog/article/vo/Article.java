package com.finn.blog.article.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Article implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String author;

    private String content;

    private String createTime;

    private String updateTime;

    private String status;

    private String type;

    private String tag;

    private String category;

    private String sort;

    private String order;
}
