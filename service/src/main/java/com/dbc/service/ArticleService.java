package com.dbc.service;

import com.dbc.entity.entity.PureArticleEntity;

import java.util.List;

public interface ArticleService {
    public List<PureArticleEntity> findAll();
    public List<PureArticleEntity> findByTypeId(int typeId);
    public Integer insertArticle(PureArticleEntity articleEntity);
}
