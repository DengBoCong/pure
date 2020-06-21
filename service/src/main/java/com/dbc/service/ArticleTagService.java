package com.dbc.service;

import com.dbc.entity.entity.PureArticleTagEntity;

import java.util.List;

public interface ArticleTagService {
    public List<PureArticleTagEntity> allInsert(List<PureArticleTagEntity> list);
    public List<PureArticleTagEntity> findAllByArticleId(int articleId);
}
