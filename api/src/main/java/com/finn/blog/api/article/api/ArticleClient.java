package com.finn.blog.api.article.api;


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
     * @param req
     * @return
     */
    Response<QueryArticleRes> query(@RequestBody QueryArticleReq req);

    /**
     * add one new article
     * @param articleVO
     * @return
     */
    Response<Void> save(@RequestBody ArticleVO articleVO);


}
