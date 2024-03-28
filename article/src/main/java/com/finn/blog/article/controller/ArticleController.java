package com.finn.blog.article.controller;

import com.finn.blog.article.entity.ArticleDTO;
import com.finn.blog.article.service.ArticleService;
import com.finn.blog.api.article.api.ArticleClient;
import com.finn.blog.api.article.vo.ArticleVO;
import com.finn.blog.api.article.vo.QueryArticleReq;
import com.finn.blog.api.article.vo.QueryArticleRes;
import com.finn.blog.api.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController("/article")
@Api(value = "Article controller " , tags = {"Article interface"})
public class ArticleController implements ArticleClient {

    @Resource
    ArticleService articleService;


    @Override
    @ApiOperation(value = "query", notes = "query article")
    @PostMapping("/query")
    public Response<QueryArticleRes> query(QueryArticleReq req) {
        return null;
    }

    @Override
    @ApiOperation(value = "save" , notes = "save article")
    @PostMapping("/save")
    public Response<Void> save(ArticleVO articleVO) {

        ArticleDTO articleDTO = new ArticleDTO();
        BeanUtils.copyProperties(articleVO,articleDTO);
//        articleDTO.init(idGenerateClient.generateIdByUUID());
        articleService.save(articleDTO);
        return null;
    }
}
