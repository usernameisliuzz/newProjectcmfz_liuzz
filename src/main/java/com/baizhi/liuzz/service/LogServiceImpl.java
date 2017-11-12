package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.dao.LogDAO;
import com.baizhi.liuzz.entity.Log;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDAO logDAO;
    public void addLog(Log log) {
        log.setId(SnowflakeIdWorker.getSnowflakeId()+"");
        logDAO.insert(log);
    }
    //@LogAnnotation(description = "查看日志")
    public List<Log> findAll() {
        return logDAO.select();
    }
}
