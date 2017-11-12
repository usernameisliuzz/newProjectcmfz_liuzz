package com.baizhi.liuzz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/31.
 */
public class Log {
    private String id;
    private String username;
    @JSONField(format = "yyyy-MM-dd ")
    private Date doDate;
    private String doThing;
    private String state;

    public Log() {
    }

    public Log(String id, String username, Date doDate, String doThing, String state) {
        this.id = id;
        this.username = username;
        this.doDate = doDate;
        this.doThing = doThing;
        this.state = state;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDoDate() {
        return doDate;
    }

    public void setDoDate(Date doDate) {
        this.doDate = doDate;
    }

    public String getDoThing() {
        return doThing;
    }

    public void setDoThing(String doThing) {
        this.doThing = doThing;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", doDate=" + doDate +
                ", doThing='" + doThing + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
