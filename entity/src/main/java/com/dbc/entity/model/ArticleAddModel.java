package com.dbc.entity.model;

import com.dbc.entity.entity.PureArticleEntity;
import com.dbc.entity.entity.PureArticleTagEntity;
import com.dbc.entity.entity.PureArticleTypeEntity;

import java.io.Serializable;
import java.util.List;

public class ArticleAddModel implements Serializable {
    private PureArticleEntity articleEntity;
    private List<PureArticleTypeEntity> classes;
    private List<PureArticleTagEntity> tags;

    public PureArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(PureArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public List<PureArticleTypeEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<PureArticleTypeEntity> classes) {
        this.classes = classes;
    }

    public List<PureArticleTagEntity> getTags() {
        return tags;
    }

    public void setTags(List<PureArticleTagEntity> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "ArticleAddModel{" +
                "articleEntity=" + articleEntity +
                ", classes=" + classes +
                ", tags=" + tags +
                '}';
    }
}
