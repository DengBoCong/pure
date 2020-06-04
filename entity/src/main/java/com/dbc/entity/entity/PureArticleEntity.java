package com.dbc.entity.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pure_article", schema = "pure", catalog = "")
public class PureArticleEntity implements Serializable {
    private int id;
    private int addTime;
    private int commentNum;
    private String content;
    private int modifyTime;
    private int pickNum;
    private int readNum;
    private byte status;
    private String subTitle;
    private String title;
    private int userId;
    private String summary;
    private int classId;
    private String articleFlag;
    private int publishTime;

    @Id
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
    @Column(name = "read_num")
    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
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
    @Column(name = "sub_title")
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
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

    @Basic
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "class_id")
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
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
                readNum == that.readNum &&
                status == that.status &&
                userId == that.userId &&
                classId == that.classId &&
                Objects.equals(content, that.content) &&
                Objects.equals(subTitle, that.subTitle) &&
                Objects.equals(title, that.title) &&
                Objects.equals(summary, that.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addTime, commentNum, content, modifyTime, pickNum, readNum, status, subTitle, title, userId, summary, classId);
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
    @Column(name = "publish_time")
    public int getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(int publishTime) {
        this.publishTime = publishTime;
    }
}
