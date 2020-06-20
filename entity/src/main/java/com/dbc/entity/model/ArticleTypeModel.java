package com.dbc.entity.model;

import com.dbc.entity.entity.PureArticleTagEntity;
import com.dbc.entity.entity.PureArticleTypeEntity;

import java.io.Serializable;
import java.util.List;

public class ArticleTypeModel implements Serializable {
    private PureArticleTypeEntity articleTypeEntity;
    private List<ArticleAddModel> articleList;

    public PureArticleTypeEntity getArticleTypeEntity() {
        return articleTypeEntity;
    }

    public void setArticleTypeEntity(PureArticleTypeEntity articleTypeEntity) {
        this.articleTypeEntity = articleTypeEntity;
    }

    public List<ArticleAddModel> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleAddModel> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "ArticleTypeModel{" +
                "articleTypeEntity=" + articleTypeEntity +
                ", articleList=" + articleList +
                '}';
    }
}
