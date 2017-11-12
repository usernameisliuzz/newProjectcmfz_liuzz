package com.baizhi.liuzz.entity;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Client {
    private String id;
    private String phone;
    private String password;
    private String state;
    private String alias;
    private String name;
    private String sex;
    private String signature;
    private String favicon;
    private String tea_id;
    private String address;
    @JSONField(format = "yyyy-MM-dd")
    private Date registerDate;
    private Teacher teacher;
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                ", alias='" + alias + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", signature='" + signature + '\'' +
                ", favicon='" + favicon + '\'' +
                ", tea_id='" + tea_id + '\'' +
                ", address='" + address + '\'' +
                ", registerDate=" + registerDate +
                ", teacher=" + teacher +
                '}';
    }

    public Client(String id, String phone, String password, String state, String alias, String name, String sex, String signature, String favicon, String tea_id, String address, Date registerDate) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.state = state;
        this.alias = alias;
        this.name = name;
        this.sex = sex;
        this.signature = signature;
        this.favicon = favicon;
        this.tea_id = tea_id;
        this.address = address;
        this.registerDate = registerDate;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client() {
    }

    public Date getRegisterDate() {

        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
