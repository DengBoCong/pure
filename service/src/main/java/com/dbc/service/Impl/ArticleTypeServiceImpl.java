package com.dbc.service.Impl;

import com.dbc.dao.ArticleTypeRepository;
import com.dbc.entity.entity.PureArticleTypeEntity;
import com.dbc.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleTypeService")
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    @Override
    public List<PureArticleTypeEntity> findAll() {
        return articleTypeRepository.findAll();
    }

    @Override
    public PureArticleTypeEntity findById(int id) {
        return articleTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<PureArticleTypeEntity> findAllByStatus(boolean status) {
        return articleTypeRepository.findAllByStatus(status);
    }

    @Override
    public PureArticleTypeEntity addOneEntity(PureArticleTypeEntity articleTypeEntity) {
        return articleTypeRepository.saveAndFlush(articleTypeEntity);
    }

    @Override
    public void deleteOneEntityById(int id) {
        articleTypeRepository.deleteById(id);
    }
}
