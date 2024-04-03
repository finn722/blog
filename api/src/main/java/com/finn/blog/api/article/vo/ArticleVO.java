package com.finn.blog.api.article.vo;

import com.finn.blog.api.article.enums.ArticleTag;
import com.finn.blog.api.article.enums.ArticleType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("Article")
@Data
public class ArticleVO implements Serializable {

    @ApiModelProperty("title")
    private String title;
    @ApiModelProperty("author")
    private String author;
    @ApiModelProperty("content")
    private String content;

    private String status;
    @ApiModelProperty("visible")
    private boolean visible;
    /**
     * @see ArticleType
     */
    @ApiModelProperty("type")
    private int type;
    @ApiModelProperty("tag,like personal or forward")
    /**
     * @see ArticleTag
     */
    private String tag;
    @ApiModelProperty("commentable")
    private boolean commentable;
    @ApiModelProperty("top")
    private boolean top;
    @ApiModelProperty("words")
    private long words;

}
