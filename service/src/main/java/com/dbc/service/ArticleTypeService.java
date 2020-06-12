package com.dbc.service;

import com.dbc.entity.entity.PureArticleTypeEntity;

import java.util.List;

public interface ArticleTypeService {
    public List<PureArticleTypeEntity> findAll();
    public PureArticleTypeEntity addOneEntity(PureArticleTypeEntity articleTypeEntity);
}
