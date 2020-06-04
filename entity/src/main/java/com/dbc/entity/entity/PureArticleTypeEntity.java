package com.dbc.entity.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pure_article_type", schema = "pure", catalog = "")
public class PureArticleTypeEntity implements Serializable {
    private int id;
    private String name;
    private String description;
    private int sort;
    private int addTime;
    private int articleNum;
    private byte status;
    private String fontCover;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "sort")
    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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
    @Column(name = "article_num")
    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    @Basic
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "font_cover")
    public String getFontCover() {
        return fontCover;
    }

    public void setFontCover(String fontCover) {
        this.fontCover = fontCover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PureArticleTypeEntity that = (PureArticleTypeEntity) o;
        return id == that.id &&
                sort == that.sort &&
                addTime == that.addTime &&
                articleNum == that.articleNum &&
                status == that.status &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(fontCover, that.fontCover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, sort, addTime, articleNum, status, fontCover);
    }
}
