package com.dbc.entity.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pure_user_record_item", schema = "pure", catalog = "")
public class PureUserRecordItemEntity implements Serializable {
    private int id;
    private String title;
    private String content;
    private int addTime;
    private int recordId;
    private String icon;
    private byte sort;
    private byte status;

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
    @Column(name = "add_time")
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "record_id")
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PureUserRecordItemEntity that = (PureUserRecordItemEntity) o;
        return id == that.id &&
                addTime == that.addTime &&
                recordId == that.recordId &&
                sort == that.sort &&
                status == that.status &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(icon, that.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, addTime, recordId, icon, sort, status);
    }
}
