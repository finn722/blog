package com.finn.blog.article.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.finn.blog.api.article.api.ArticleClient;
import com.finn.blog.api.article.vo.ArticleVO;
import com.finn.blog.api.article.vo.QueryArticleReq;
import com.finn.blog.api.article.vo.QueryArticleRes;
import com.finn.blog.api.common.Response;
import com.finn.blog.article.entity.ArticleDTO;
import com.finn.blog.article.service.ArticleService;
import com.finn.blog.common.executor.CommonExecutor;
import com.finn.blog.common.service.LockService;
import com.finn.blog.common.id.IdGeneration;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Article module
 * <p>
 * 1. add one new article
 * 2. query all article list, support paging, sorting, filtering
 * - paging: page number, page size
 * - sorting: sort by create time, update time, view count, comment count
 * - filtering: filter by title, author, create time, update time, status, type, tag, category
 * - return: article list, total count
 * 3.
 *
 * @Author : finn
 * @Create : 2021/9/17
 */
@RestController("/article")
@Api(value = "Article controller ", tags = {"Article interface"})
public class ArticleController implements ArticleClient {

    @Resource
    ArticleService articleService;

    @Resource
    CommonExecutor executor;

    @Resource
    LockService lockService;

    @Override
    @ApiOperation(value = "query", notes = "query article")
    @PostMapping("/query")
    public Response<QueryArticleRes> query(QueryArticleReq req) {
        return null;
    }

    @Override
    @ApiOperation(value = "save", notes = "save article")
    @PostMapping("/save")
    public Response<Boolean> save(ArticleVO articleVO) {
        return executor.executeWithLock(lockService, articleVO.getTitle() + "&" + articleVO.getAuthor(),() -> {
            ArticleDTO articleDTO = new ArticleDTO();
            BeanUtils.copyProperties(articleVO, articleDTO);
            articleDTO.init(IdGeneration.generateId());
            return articleService.save(articleDTO);
        }, "save", articleVO);
    }

    @Override
    @ApiOperation(value = "queryByPage", notes = "query article by page")
    @PostMapping(value = "/query/page",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<IPage<ArticleVO>> queryByPage(Page<ArticleVO> page, ArticleVO articleVO) {
        IPage<ArticleDTO> pageDTO = null;
        ArticleDTO articleDTO = new ArticleDTO();
        if (page != null) {
            pageDTO = new Page<>(page.getCurrent(), page.getSize());
        }
        if (articleVO != null) {
            BeanUtils.copyProperties(articleVO, articleDTO);
        }
        return Response.ok(articleService.queryByPage(pageDTO, articleDTO));
    }

    @Override
    @ApiOperation(value = "pageQuery", notes = "page query")
    @GetMapping("/pageQuery")
    public Response<IPage<ArticleVO>> pageQuery(){
        return executor.execute(() -> articleService.queryByPage(null, null)
                , "pageQuery", (Object) null);
    }



}
