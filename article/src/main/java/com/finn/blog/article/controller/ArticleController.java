package com.finn.blog.article.controller;

import com.finn.blog.api.article.api.ArticleClient;
import com.finn.blog.api.article.vo.ArticleVO;
import com.finn.blog.api.article.vo.QueryArticleReq;
import com.finn.blog.api.article.vo.QueryArticleRes;
import com.finn.blog.api.common.Response;
import com.finn.blog.api.id.IdGenerateClient;
import com.finn.blog.article.entity.ArticleDTO;
import com.finn.blog.article.service.ArticleService;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Article module
 *
 * 1. add one new article
 * 2. query all article list, support paging, sorting, filtering
 *      - paging: page number, page size
 *      - sorting: sort by create time, update time, view count, comment count
 *      - filtering: filter by title, author, create time, update time, status, type, tag, category
 *      - return: article list, total count
 * 3.
 *
 *
 *
 * @Author : finn
 * @Create : 2021/9/17
 */
public class ArticleController implements ArticleClient{

    @Resource
    ArticleService articleService;

    @Resource
    IdGenerateClient idGenerateClient;

    @Override
    public Response<QueryArticleRes> query(QueryArticleReq req) {
        return null;
    }

    @Override
    public Response<Void> save(ArticleVO articleVO) {

        ArticleDTO articleDTO = new ArticleDTO();
        BeanUtils.copyProperties(articleVO,articleDTO);
        articleDTO.init(idGenerateClient.generateIdByUUID());
        articleService.save(articleDTO);
        return null;
    }
}
