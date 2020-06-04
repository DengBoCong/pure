package com.dbc.service;

import com.dbc.entity.entity.PureArticleEntity;

import java.util.List;

public interface ArticleService {
    public List<PureArticleEntity> findAll();
    public Integer insertArticle(PureArticleEntity articleEntity);
}
