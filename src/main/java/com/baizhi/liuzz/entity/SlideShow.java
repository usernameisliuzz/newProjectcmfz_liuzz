package com.baizhi.liuzz.entity;

/**
 * Created by Administrator on 2017/10/26.
 */
public class SlideShow {
    private String sli_id;
    private String sli_url;
    private String sli_discription;
    private String sli_name;
    private String sli_oldname;
    private String state;
    private String sli_size;

    public SlideShow() {
    }

    public SlideShow(String sli_id, String sli_url, String sli_discription, String sli_name, String sli_oldname, String state, String sli_size) {
        this.sli_id = sli_id;
        this.sli_url = sli_url;
        this.sli_discription = sli_discription;
        this.sli_name = sli_name;
        this.sli_oldname = sli_oldname;
        this.state = state;
        this.sli_size = sli_size;
    }

    public String getSli_id() {
        return sli_id;
    }

    public void setSli_id(String sli_id) {
        this.sli_id = sli_id;
    }

    public String getSli_url() {
        return sli_url;
    }

    public void setSli_url(String sli_url) {
        this.sli_url = sli_url;
    }

    public String getSli_discription() {
        return sli_discription;
    }

    public void setSli_discription(String sli_discription) {
        this.sli_discription = sli_discription;
    }

    public String getSli_name() {
        return sli_name;
    }

    public void setSli_name(String sli_name) {
        this.sli_name = sli_name;
    }

    public String getSli_oldname() {
        return sli_oldname;
    }

    public void setSli_oldname(String sli_oldname) {
        this.sli_oldname = sli_oldname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSli_size() {
        return sli_size;
    }

    public void setSli_size(String sli_size) {
        this.sli_size = sli_size;
    }

    @Override
    public String toString() {
        return "SlideShow{" +
                "sli_id='" + sli_id + '\'' +
                ", sli_url='" + sli_url + '\'' +
                ", sli_discription='" + sli_discription + '\'' +
                ", sli_name='" + sli_name + '\'' +
                ", sli_oldname='" + sli_oldname + '\'' +
                ", state='" + state + '\'' +
                ", sli_size='" + sli_size + '\'' +
                '}';
    }
}
