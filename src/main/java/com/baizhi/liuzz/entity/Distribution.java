package com.baizhi.liuzz.entity;

/**
 * Created by Administrator on 2017/11/1.
 */
public class Distribution {
    private String name;
    private String value;

    public Distribution() {
    }

    public Distribution(String name, String value) {

        this.name = name;
        this.value = value;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
