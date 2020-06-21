package com.dbc.entity.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pure_notice", schema = "pure", catalog = "")
public class PureNoticeEntity implements Serializable {
    private int id;
    private String title;
    private String content;
    private String url;
    private String type;
    private byte status;
    private int addTime;
    private byte sort;
    private String titleColor;
    private String contentColor;

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "add_time")
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "sort")
    public byte getSort() {
        return sort;
    }

    public void setSort(byte sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "title_color")
    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    @Basic
    @Column(name = "content_color")
    public String getContentColor() {
        return contentColor;
    }

    public void setContentColor(String contentColor) {
        this.contentColor = contentColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PureNoticeEntity that = (PureNoticeEntity) o;
        return id == that.id &&
                status == that.status &&
                addTime == that.addTime &&
                sort == that.sort &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(url, that.url) &&
                Objects.equals(type, that.type) &&
                Objects.equals(titleColor, that.titleColor) &&
                Objects.equals(contentColor, that.contentColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, url, type, status, addTime, sort, titleColor, contentColor);
    }
}
