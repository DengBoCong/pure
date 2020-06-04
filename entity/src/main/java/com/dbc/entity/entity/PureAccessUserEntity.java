package com.dbc.entity.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pure_access_user", schema = "pure", catalog = "")
public class PureAccessUserEntity implements Serializable {
    private int id;
    private int userId;
    private String accessPath;
    private int addTime;
    private byte sort;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "access_path")
    public String getAccessPath() {
        return accessPath;
    }

    public void setAccessPath(String accessPath) {
        this.accessPath = accessPath;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PureAccessUserEntity that = (PureAccessUserEntity) o;
        return id == that.id &&
                userId == that.userId &&
                addTime == that.addTime &&
                sort == that.sort &&
                Objects.equals(accessPath, that.accessPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, accessPath, addTime, sort);
    }
}
