package com.baizhi.liuzz.entity;

/**
 * Created by Administrator on 2017/10/27.
 */
public class Chapter {
    private String id;
    private String fal_id;
    private String name;
    private String ch_url;
    private String ch_size;
    private String ch_state;
    private String ch_newName;
    private String counts;

    public Chapter(String id, String fal_id, String name, String ch_url, String ch_size, String ch_state, String ch_newName, String counts) {
        this.id = id;
        this.fal_id = fal_id;
        this.name = name;
        this.ch_url = ch_url;
        this.ch_size = ch_size;
        this.ch_state = ch_state;
        this.ch_newName = ch_newName;
        this.counts = counts;
    }

    public String getCounts() {

        return counts;
    }

    public void setCount(String counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", fal_id='" + fal_id + '\'' +
                ", name='" + name + '\'' +
                ", ch_url='" + ch_url + '\'' +
                ", ch_size='" + ch_size + '\'' +
                ", ch_state='" + ch_state + '\'' +
                ", ch_newName='" + ch_newName + '\'' +
                ", counts='" + counts + '\'' +
                '}';
    }

    public Chapter() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFal_id() {
        return fal_id;
    }

    public void setFal_id(String fal_id) {
        this.fal_id = fal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCh_url() {
        return ch_url;
    }

    public void setCh_url(String ch_url) {
        this.ch_url = ch_url;
    }

    public String getCh_size() {
        return ch_size;
    }

    public void setCh_size(String ch_size) {
        this.ch_size = ch_size;
    }

    public String getCh_state() {
        return ch_state;
    }

    public void setCh_state(String ch_state) {
        this.ch_state = ch_state;
    }

    public String getCh_newName() {
        return ch_newName;
    }

    public void setCh_newName(String ch_newName) {
        this.ch_newName = ch_newName;
    }

}
