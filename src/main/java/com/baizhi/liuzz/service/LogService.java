package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.entity.Log;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface LogService {
    public void addLog(Log log);
    //@LogAnnotation(description = "查看日志")
    public List<Log> findAll();
}
