package com.baizhi.liuzz.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
public class Counts {
    private List<String> name;
    private List<String> num;

    public Counts() {
    }

    public Counts(List<String> name, List<String> num) {

        this.name = name;
        this.num = num;
    }

    public List<String> getName() {

        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getNum() {
        return num;
    }

    public void setNum(List<String> num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "counts{" +
                "name=" + name +
                ", num=" + num +
                '}';
    }
}
