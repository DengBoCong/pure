package com.dbc.service.Impl;

import com.dbc.dao.ArticleTagRepository;
import com.dbc.entity.entity.PureArticleTagEntity;
import com.dbc.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleTagService")
public class ArticleTagServiceImpl implements ArticleTagService {
    @Autowired
    private ArticleTagRepository articleTagRepository;

    @Override
    public List<PureArticleTagEntity> allInsert(List<PureArticleTagEntity> list) {
        return articleTagRepository.saveAll(list);
    }

    @Override
    public List<PureArticleTagEntity> findAllByArticleId(int articleId) {
        return articleTagRepository.findAllByArticleId(articleId);
    }
}
