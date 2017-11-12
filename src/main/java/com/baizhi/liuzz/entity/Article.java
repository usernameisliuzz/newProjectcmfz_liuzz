package com.baizhi.liuzz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/30.
 */
public class Article {
    private String id;
    private String tea_id;
    private String art_name;
    @JSONField(format = "yyyy-MM-dd")
    private Date pubDate;
    private String addr_picture;
    private String content;
    private String state;
    private Teacher teacher;
    private String type="1";

    public Article() {
    }

    public Article(String id, String tea_id, String art_name, Date pubDate, String addr_picture, String content, String state) {
        this.id = id;
        this.tea_id = tea_id;
        this.art_name = art_name;
        this.pubDate = pubDate;
        this.addr_picture = addr_picture;
        this.content = content;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public String getArt_name() {
        return art_name;
    }

    public void setArt_name(String art_name) {
        this.art_name = art_name;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getAddr_picture() {
        return addr_picture;
    }

    public void setAddr_picture(String addr_picture) {
        this.addr_picture = addr_picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", tea_id='" + tea_id + '\'' +
                ", art_name='" + art_name + '\'' +
                ", pubDate=" + pubDate +
                ", addr_picture='" + addr_picture + '\'' +
                ", content='" + content + '\'' +
                ", state='" + state + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
