package com.baizhi.liuzz.controller;

import com.baizhi.liuzz.entity.Log;
import com.baizhi.liuzz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("log")
public class logController {
    @Autowired
    private LogService logService;

    @RequestMapping("findLog")
    @ResponseBody
    public List<Log> findLog(){
        return logService.findAll();
    }

}
