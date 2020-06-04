package com.dbc.service.Impl;

import com.dbc.dao.ArticleRepository;
import com.dbc.entity.entity.PureArticleEntity;
import com.dbc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<PureArticleEntity> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Integer insertArticle(PureArticleEntity articleEntity) {
        articleRepository.save(articleEntity);
        return 0;
    }
}
