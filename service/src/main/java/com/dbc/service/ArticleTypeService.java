package com.dbc.service;

import com.dbc.entity.entity.PureArticleTypeEntity;

import java.util.List;

public interface ArticleTypeService {
    public List<PureArticleTypeEntity> findAll();
    public PureArticleTypeEntity findById(int id);
    public List<PureArticleTypeEntity> findAllByStatus(boolean status);
    public PureArticleTypeEntity addOneEntity(PureArticleTypeEntity articleTypeEntity);
    public void deleteOneEntityById(int id);
}
