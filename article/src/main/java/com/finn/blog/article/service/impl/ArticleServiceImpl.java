package com.finn.blog.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finn.blog.api.article.vo.ArticleVO;
import com.finn.blog.api.common.BusinessErrorEnum;
import com.finn.blog.article.entity.ArticleDTO;
import com.finn.blog.article.repository.ArticleMapper;
import com.finn.blog.article.service.ArticleService;
import com.finn.blog.common.exception.BusinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleDTO> implements ArticleService {

    @Resource
    ArticleMapper articleMapper;

    @Override
    public boolean save(ArticleDTO entity) {
        ArticleDTO articleDTO = queryByArticleId(entity.getArticleId());
        if(articleDTO != null){
            throw new BusinessException(BusinessErrorEnum.DATA_EXIST);
        }

        return super.save(entity);
    }

    public ArticleDTO queryByArticleId(String articleId) {
        if(articleId == null || "".equals(articleId)){
            throw new BusinessException(BusinessErrorEnum.PARAM_ERROR);
        }
        return articleMapper.selectOne(new LambdaQueryWrapper<ArticleDTO>()
                .eq(ArticleDTO::getArticleId,articleId));
    }

    public IPage<ArticleVO> queryByPage(IPage<ArticleDTO> page, ArticleDTO articleDTO) {

        IPage<ArticleDTO> articleDTOIPage;
        if(page == null){
            page = new Page<>(1, 10);
        }
        if (articleDTO == null) {
            articleDTOIPage = articleMapper.selectPage(page,new LambdaQueryWrapper<ArticleDTO>()
                    .eq(ArticleDTO::isVisible, true)
                    .orderByDesc(ArticleDTO::getCreateTime));
        }else{
            articleDTOIPage = articleMapper.selectPage(page, new LambdaQueryWrapper<ArticleDTO>()
                    .eq(articleDTO.getArticleId() != null, ArticleDTO::getArticleId, articleDTO.getArticleId())
                    .like(articleDTO.getTitle() != null, ArticleDTO::getTitle, articleDTO.getTitle())
                    .eq(articleDTO.getAuthor() != null, ArticleDTO::getAuthor, articleDTO.getAuthor())
                    .eq(articleDTO.getStatus() != null, ArticleDTO::getStatus, articleDTO.getStatus())
                    .eq(ArticleDTO::isVisible, articleDTO.isVisible())
                    .eq(ArticleDTO::getType, articleDTO.getType())
                    .eq(articleDTO.getTag() != null, ArticleDTO::getTag, articleDTO.getTag())
                    .eq(ArticleDTO::isCommentable, articleDTO.isCommentable())
                    .orderByDesc(ArticleDTO::getCreateTime));
        }
        IPage<ArticleVO> voPage = new Page<>(articleDTOIPage.getCurrent(), articleDTOIPage.getSize());
        voPage.setTotal(articleDTOIPage.getTotal());

        List<ArticleVO> voList = articleDTOIPage.getRecords().stream().map(article -> {
            ArticleVO articleVO = new ArticleVO();
            BeanUtils.copyProperties(article, articleVO);
            return articleVO;
        }).collect(Collectors.toList());

        voPage.setRecords(voList);
        return voPage;
    }
}
