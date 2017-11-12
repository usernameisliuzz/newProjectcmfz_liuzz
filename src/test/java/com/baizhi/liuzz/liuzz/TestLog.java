package com.baizhi.liuzz.liuzz;

import com.baizhi.liuzz.dao.LogDAO;
import com.baizhi.liuzz.entity.Log;
import com.baizhi.liuzz.service.LogService;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public class TestLog extends BaseTest{
    @Autowired
    private LogService logService;
    @Test
    public void insert(){
        Log log=new Log(SnowflakeIdWorker.getSnowflakeId()+"","小王",new Date(),"嘿嘿","good");
        logService.addLog(log);
    }
    @Test
    public void findAll(){
        List<Log> logs = logService.findAll();
        System.out.println(logs);
    }
}
