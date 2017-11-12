package com.baizhi.liuzz.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public class Album {
    private String id;
    private String name;
    private String al_author;
    private String al_announcer;
    private String al_number;
    private String al_pubdate;
    private String al_content;
    private String state;
    private List<Chapter> children;
    private String type="0";
    private String al_url;

    public String getAl_url() {
        return al_url;
    }

    public void setAl_url(String al_url) {
        this.al_url = al_url;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", al_author='" + al_author + '\'' +
                ", al_announcer='" + al_announcer + '\'' +
                ", al_number='" + al_number + '\'' +
                ", al_pubdate='" + al_pubdate + '\'' +
                ", al_content='" + al_content + '\'' +
                ", state='" + state + '\'' +
                ", children=" + children +
                ", type='" + type + '\'' +
                ", al_url='" + al_url + '\'' +
                '}';
    }

    public Album() {
    }

    public Album(String id, String name, String al_author, String al_announcer, String al_number, String al_pubdate, String al_content, String state, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.al_author = al_author;
        this.al_announcer = al_announcer;
        this.al_number = al_number;
        this.al_pubdate = al_pubdate;
        this.al_content = al_content;
        this.state = state;
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAl_author() {
        return al_author;
    }

    public void setAl_author(String al_author) {
        this.al_author = al_author;
    }

    public String getAl_announcer() {
        return al_announcer;
    }

    public void setAl_announcer(String al_announcer) {
        this.al_announcer = al_announcer;
    }

    public String getAl_number() {
        return al_number;
    }

    public void setAl_number(String al_number) {
        this.al_number = al_number;
    }

    public String getAl_pubdate() {
        return al_pubdate;
    }

    public void setAl_pubdate(String al_pubdate) {
        this.al_pubdate = al_pubdate;
    }

    public String getAl_content() {
        return al_content;
    }

    public void setAl_content(String al_content) {
        this.al_content = al_content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

}
