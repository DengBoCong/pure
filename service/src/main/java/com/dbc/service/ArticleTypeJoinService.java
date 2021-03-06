package com.dbc.service;

import com.dbc.entity.entity.PureArticleTypeJoinEntity;

import java.util.List;

public interface ArticleTypeJoinService {
    public List<PureArticleTypeJoinEntity> findAllByTypeId(int typeId);
    public PureArticleTypeJoinEntity oneInsert(PureArticleTypeJoinEntity articleTypeJoinEntity);
    public List<PureArticleTypeJoinEntity> allInsert(List<PureArticleTypeJoinEntity> list);
}
