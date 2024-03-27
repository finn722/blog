package com.finn.blog.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finn.blog.article.entity.ArticleDTO;
import com.finn.blog.article.repository.ArticleMapper;
import com.finn.blog.article.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleDTO> implements ArticleService {
}
