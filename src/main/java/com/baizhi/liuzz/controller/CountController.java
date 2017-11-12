package com.baizhi.liuzz.controller;

import com.baizhi.liuzz.entity.Client;
import com.baizhi.liuzz.entity.Counts;
import com.baizhi.liuzz.entity.Distribution;
import com.baizhi.liuzz.service.CountService;
import com.baizhi.liuzz.service.DistributionService;
import com.baizhi.liuzz.util.weekBetween;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("count")
public class CountController {
    @Autowired
    private CountService countService;
    @Autowired
    private DistributionService distributionService;
    @RequestMapping("activeclient")
    @ResponseBody
    public Counts nameAndnum(){
        int day=7;
        Counts counts=new Counts();
        List<String> name=new ArrayList<String>();
        List<String> num=new ArrayList<String>();
        Client longDate = countService.getLongDate();
        int weeks = weekBetween.getWeeks(new Date(), longDate.getRegisterDate());
        for(int i=1; i <= weeks; i++){
            name.add("第"+i+"周");
            num.add(countService.findCount(day+"").getCounts());
            day+=7;
        }
        counts.setName(name);
        counts.setNum(num);
        return counts;
    }
    @RequestMapping("clientDistribution")
    @ResponseBody
    public List<Distribution> clientDistribution(){
        return distributionService.findAll();
    }
}
