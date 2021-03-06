package com.dbc.entity.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pure_article_type_join", schema = "pure", catalog = "")
public class PureArticleTypeJoinEntity implements Serializable {
    private int id;
    private int addTime;
    private int articleId;
    private int typeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "add_time")
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "article_id")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "type_id")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PureArticleTypeJoinEntity that = (PureArticleTypeJoinEntity) o;
        return id == that.id &&
                addTime == that.addTime &&
                articleId == that.articleId &&
                typeId == that.typeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addTime, articleId, typeId);
    }
}
