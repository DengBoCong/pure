package com.dbc.service.Impl;

import com.dbc.dao.ArticleTypeJoinRepository;
import com.dbc.entity.entity.PureArticleTypeJoinEntity;
import com.dbc.service.ArticleTypeJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleTypeJoinService")
public class ArticleTypeJoinServiceImpl implements ArticleTypeJoinService {
    @Autowired
    private ArticleTypeJoinRepository articleTypeJoinRepository;

    @Override
    public List<PureArticleTypeJoinEntity> findAllByTypeId(int typeId) {
        return articleTypeJoinRepository.findAllByTypeId(typeId);
    }

    @Override
    public PureArticleTypeJoinEntity oneInsert(PureArticleTypeJoinEntity articleTypeJoinEntity) {
        return articleTypeJoinRepository.saveAndFlush(articleTypeJoinEntity);
    }

    @Override
    public List<PureArticleTypeJoinEntity> allInsert(List<PureArticleTypeJoinEntity> list) {
        return articleTypeJoinRepository.saveAll(list);
    }
}
