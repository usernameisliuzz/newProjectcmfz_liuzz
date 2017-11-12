package com.baizhi.liuzz.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public class Count {
    private String counts;

    public Count(String counts) {
        this.counts = counts;
    }

    public Count() {
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "Count{" +
                "counts='" + counts + '\'' +
                '}';
    }
}
