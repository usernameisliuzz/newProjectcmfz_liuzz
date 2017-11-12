package com.baizhi.liuzz.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public class Teacher {
    private String id;
    private String tea_name;
    private String addr_photo;
    private String state;
    protected List<Article> articles;

    public Teacher() {
    }

    public Teacher(String id, String tea_name, String addr_photo, String state) {
        this.id = id;
        this.tea_name = tea_name;
        this.addr_photo = addr_photo;
        this.state = state;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public String getAddr_photo() {
        return addr_photo;
    }

    public void setAddr_photo(String addr_photo) {
        this.addr_photo = addr_photo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", tea_name='" + tea_name + '\'' +
                ", addr_photo='" + addr_photo + '\'' +
                ", state='" + state + '\'' +
                ", articles=" + articles +
                '}';
    }
}
