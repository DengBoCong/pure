package com.dbc.entity.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pure_advertise", schema = "pure", catalog = "")
public class PureAdvertiseEntity implements Serializable {
    private int id;
    private int addTime;
    private String cover;
    private String description;
    private short sort;
    private short status;
    private String title;
    private String type;
    private String url;
    private int reserveTime;

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
    @Column(name = "cover")
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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
    public short getSort() {
        return sort;
    }

    public void setSort(byte sort) {
        this.sort = sort;
    }

    public void setSort(short sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "status")
    public short getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public void setStatus(short status) {
        this.status = status;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "reserve_time")
    public int getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(int reserveTime) {
        this.reserveTime = reserveTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PureAdvertiseEntity that = (PureAdvertiseEntity) o;
        return id == that.id &&
                addTime == that.addTime &&
                sort == that.sort &&
                status == that.status &&
                Objects.equals(cover, that.cover) &&
                Objects.equals(description, that.description) &&
                Objects.equals(title, that.title) &&
                Objects.equals(type, that.type) &&
                Objects.equals(url, that.url) &&
                Objects.equals(reserveTime, that.reserveTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addTime, cover, description, sort, status, title, type, url, reserveTime);
    }
}
