package com.baizhi.liuzz.dao;

import com.baizhi.liuzz.entity.Log;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface LogDAO {
    public void insert(Log log);
    public List<Log> select();
}
