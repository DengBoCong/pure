package com.dbc.entity.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pure_language", schema = "pure", catalog = "")
public class PureLanguageEntity {
    private int id = 0;
    private String type = "";
    private String title = "";
    private String zhCn = "";
    private String zhTw = "";
    private String enUs = "";
    private int addTime = 0;

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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String key) {
        this.title = key;
    }

    @Basic
    @Column(name = "zh_cn")
    public String getZhCn() {
        return zhCn;
    }

    public void setZhCn(String zhCn) {
        this.zhCn = zhCn;
    }

    @Basic
    @Column(name = "zh_tw")
    public String getZhTw() {
        return zhTw;
    }

    public void setZhTw(String zhTw) {
        this.zhTw = zhTw;
    }

    @Basic
    @Column(name = "en_us")
    public String getEnUs() {
        return enUs;
    }

    public void setEnUs(String enUs) {
        this.enUs = enUs;
    }

    @Basic
    @Column(name = "add_time")
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PureLanguageEntity that = (PureLanguageEntity) o;
        return id == that.id &&
                addTime == that.addTime &&
                Objects.equals(type, that.type) &&
                Objects.equals(title, that.title) &&
                Objects.equals(zhCn, that.zhCn) &&
                Objects.equals(zhTw, that.zhTw) &&
                Objects.equals(enUs, that.enUs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, title, zhCn, zhTw, enUs, addTime);
    }
}
