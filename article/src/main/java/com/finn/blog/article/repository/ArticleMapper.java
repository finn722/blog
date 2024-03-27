package com.finn.blog.article.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finn.blog.article.entity.ArticleDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<ArticleDTO> {

}
