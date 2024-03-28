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
    /**
     * @see ArticleType
     */
    @ApiModelProperty("type")
    private String type;
    @ApiModelProperty("tag,like personal or forward")
    /**
     * @see ArticleTag
     */
    private String tag;
    @ApiModelProperty("visible")
    private int visible;
    @ApiModelProperty("commentable")
    private int commentable;
    @ApiModelProperty("top")
    private int top;
    @ApiModelProperty("words")
    private long words;

}
