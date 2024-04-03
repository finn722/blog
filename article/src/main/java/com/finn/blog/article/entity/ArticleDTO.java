package com.finn.blog.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.finn.blog.api.article.enums.ArticleStatus;
import com.finn.blog.api.article.enums.ArticleTag;
import com.finn.blog.api.article.enums.ArticleType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_article")
public class ArticleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    public Long id;
    @TableField("article_id")
    public String articleId;
    @TableField("title")
    private String title;
    @TableField("author")
    private String author;
    /**
     * @see ArticleStatus
     */
    @TableField("status")
    private String status;
    @TableField("visible")
    private boolean visible;
    /**
     * @see ArticleType
     */
    @TableField("type")
    private int type;
    @TableField("publish_date")
    private Date publishDate;
    /**
     * @see ArticleTag
     */
    @TableField("tag")
    private String tag;

    @TableField("commentable")
    private boolean commentable;

    @TableField("top")
    private boolean top;

    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;


    public void init(String articleId) {
        this.createTime = new Date();
        this.updateTime = new Date();
        this.articleId = articleId;
        this.status = this.status == null || "".equals(this.status) ? ArticleStatus.DRAFT.name() : this.status;
        this.visible = true;
    }


}
