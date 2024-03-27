package com.finn.blog.api.article.api;


import com.finn.blog.api.article.vo.ArticleVO;
import com.finn.blog.api.article.vo.QueryArticleReq;
import com.finn.blog.api.article.vo.QueryArticleRes;
import com.finn.blog.api.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Api(value = "ArticleClient", tags = "Article")
public interface ArticleClient {
    /**
     *
     */
    @PostMapping("/article/query")
    @ApiOperation(value = "query", notes = "query article")
    Response<QueryArticleRes> query(@RequestBody QueryArticleReq req);

    @PostMapping("/article/save")
    @ApiOperation(value = "save", notes = "save article")
    Response<Void> save(@RequestBody ArticleVO articleVO);
















}
