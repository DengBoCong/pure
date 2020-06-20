package com.dbc.entity.model;

import com.dbc.entity.entity.PureArticleTagEntity;
import com.dbc.entity.entity.PureArticleTypeEntity;

import java.io.Serializable;
import java.util.List;

public class ArticleAddModel implements Serializable {
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
    private List<PureArticleTypeEntity> classes;
    private String articleFlag;
    private int publishTime;
    private List<PureArticleTagEntity> tags;

    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(int modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getPickNum() {
        return pickNum;
    }

    public void setPickNum(int pickNum) {
        this.pickNum = pickNum;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<PureArticleTypeEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<PureArticleTypeEntity> classes) {
        this.classes = classes;
    }

    public String getArticleFlag() {
        return articleFlag;
    }

    public void setArticleFlag(String articleFlag) {
        this.articleFlag = articleFlag;
    }

    public int getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(int publishTime) {
        this.publishTime = publishTime;
    }

    public List<PureArticleTagEntity> getTags() {
        return tags;
    }

    public void setTags(List<PureArticleTagEntity> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
