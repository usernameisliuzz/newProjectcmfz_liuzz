package com.baizhi.liuzz.entity;

/**
 * Created by Administrator on 2017/11/3.
 */
public class Head {
    private String thumbnail;
    private String desc1;
    private String id;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc(String desc1) {
        this.desc1 = desc1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "head{" +
                "thumbnail='" + thumbnail + '\'' +
                ", desc1='" + desc1 + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
