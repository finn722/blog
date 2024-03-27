package com.finn.blog.api.article.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class QueryArticleReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String content;

    private String author;

    private String createTime;

    private String updateTime;

    private String status;

    private String type;

    private String tag;

    private String category;

    private String sort;

    private String order;

    private Integer pageNum;

}
