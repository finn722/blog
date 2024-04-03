package com.finn.blog.article.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.finn.blog.api.article.vo.ArticleVO;
import com.finn.blog.article.entity.ArticleDTO;


public interface ArticleService extends IService<ArticleDTO> {

    IPage<ArticleVO> queryByPage(IPage<ArticleDTO> page, ArticleDTO articleDTO);

}
