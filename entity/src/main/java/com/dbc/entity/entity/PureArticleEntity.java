package com.dbc.entity.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pure_article", schema = "pure", catalog = "")
public class PureArticleEntity implements Serializable {
    private int id;
    private int addTime;
    private String articleFlag;
    private int commentNum;
    private String content;
    private int modifyTime;
    private int pickNum;
    private int publishTime;
    private int readNum;
    private short status;
    private String subTitle;
    private String summary;
    private String title;
    private int userId;

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
    @Column(name = "article_flag")
    public String getArticleFlag() {
        return articleFlag;
    }

    public void setArticleFlag(String articleFlag) {
        this.articleFlag = articleFlag;
    }

    @Basic
    @Column(name = "comment_num")
    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
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
    @Column(name = "modify_time")
    public int getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(int modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "pick_num")
    public int getPickNum() {
        return pickNum;
    }

    public void setPickNum(int pickNum) {
        this.pickNum = pickNum;
    }

    @Basic
    @Column(name = "publish_time")
    public int getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(int publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "read_num")
    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    @Basic
    @Column(name = "status")
    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Basic
    @Column(name = "sub_title")
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Basic
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PureArticleEntity that = (PureArticleEntity) o;
        return id == that.id &&
                addTime == that.addTime &&
                commentNum == that.commentNum &&
                modifyTime == that.modifyTime &&
                pickNum == that.pickNum &&
                publishTime == that.publishTime &&
                readNum == that.readNum &&
                status == that.status &&
                userId == that.userId &&
                Objects.equals(articleFlag, that.articleFlag) &&
                Objects.equals(content, that.content) &&
                Objects.equals(subTitle, that.subTitle) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addTime, articleFlag, commentNum, content, modifyTime, pickNum, publishTime, readNum, status, subTitle, summary, title, userId);
    }
}
