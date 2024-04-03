package com.finn.blog.api.article.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.finn.blog.api.article.vo.ArticleVO;
import com.finn.blog.api.article.vo.QueryArticleReq;
import com.finn.blog.api.article.vo.QueryArticleRes;
import com.finn.blog.api.common.Response;
import org.springframework.web.bind.annotation.RequestBody;



public interface ArticleClient {

    /**
     * query all article list, support paging, sorting, filtering
     *        - paging: page number, page size
     *        - sorting: sort by create time, update time, view count, comment count
     *        - filtering: filter by title, author, create time, update time, status, type, tag, category
     *        - return: article list, total count
     * @param req request
     * @return Response<QueryArticleRes>
     */
    Response<QueryArticleRes> query(@RequestBody QueryArticleReq req);

    /**
     * add one new article
     * @param articleVO request body
     * @return Response<Void>
     */
    Response<Boolean> save(@RequestBody ArticleVO articleVO);

    Response<IPage<ArticleVO>> queryByPage(@RequestBody Page<ArticleVO> page, @RequestBody ArticleVO articleVO);
    Response<IPage<ArticleVO>> pageQuery();



}
