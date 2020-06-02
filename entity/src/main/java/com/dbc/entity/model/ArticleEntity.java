package com.dbc.entity.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pure_article", schema = "pure", catalog = "")
public class ArticleEntity {
    private int id;
    private String content;
    private String title;
    private String subTitle;
    private int addTime;
    private byte status;
    private int userId;
    private int readNum;
    private int pickNum;
    private int commentNum;
    private int modifyTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "add_time")
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
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
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Column(name = "pick_num")
    public int getPickNum() {
        return pickNum;
    }

    public void setPickNum(int pickNum) {
        this.pickNum = pickNum;
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
    @Column(name = "modify_time")
    public int getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(int modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleEntity that = (ArticleEntity) o;
        return id == that.id &&
                addTime == that.addTime &&
                status == that.status &&
                userId == that.userId &&
                readNum == that.readNum &&
                pickNum == that.pickNum &&
                commentNum == that.commentNum &&
                modifyTime == that.modifyTime &&
                Objects.equals(content, that.content) &&
                Objects.equals(title, that.title) &&
                Objects.equals(subTitle, that.subTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, title, subTitle, addTime, status, userId, readNum, pickNum, commentNum, modifyTime);
    }
}
