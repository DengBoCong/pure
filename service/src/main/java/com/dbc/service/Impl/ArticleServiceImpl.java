package com.dbc.service.Impl;

import com.dbc.dao.ArticleRepository;
import com.dbc.dao.ArticleTypeJoinRepository;
import com.dbc.entity.entity.PureArticleEntity;
import com.dbc.entity.entity.PureArticleTypeEntity;
import com.dbc.entity.entity.PureArticleTypeJoinEntity;
import com.dbc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleTypeJoinRepository articleTypeJoinRepository;

    @Override
    public List<PureArticleEntity> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<PureArticleEntity> findByTypeId(int typeId) {
        List<PureArticleTypeJoinEntity> list = articleTypeJoinRepository.findAllByTypeId(typeId);
        List<PureArticleEntity> resultList = new ArrayList<>();
        PureArticleEntity articleEntity = null;
        for (PureArticleTypeJoinEntity articleTypeJoinEntity : list) {
            articleEntity = articleRepository.findById(articleTypeJoinEntity.getArticleId()).orElse(null);
            if (articleEntity != null)
                resultList.add(articleEntity);
        }
        return resultList;
    }

    @Override
    public PureArticleEntity addOneEntity(PureArticleEntity articleEntity) {
        return articleRepository.saveAndFlush(articleEntity);
    }
}
