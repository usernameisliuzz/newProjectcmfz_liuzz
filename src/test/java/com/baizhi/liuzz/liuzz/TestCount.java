package com.baizhi.liuzz.liuzz;

import com.baizhi.liuzz.entity.Client;
import com.baizhi.liuzz.entity.Count;
import com.baizhi.liuzz.service.CountService;
import com.baizhi.liuzz.util.weekBetween;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/1.
 */
public class TestCount extends BaseTest {
    @Autowired
    private CountService countService;
    @Test
    public void findCount(){
        Count count = countService.findCount("7");
        String counts = count.getCounts();
        System.out.println(count);
    }
    @Test
    public void getLongDate(){
        Client longDate = countService.getLongDate();
        System.out.println(longDate.getRegisterDate());
        System.out.println(new Date());
        int weeks = weekBetween.getWeeks(new Date(), longDate.getRegisterDate());
        System.out.println(weeks);
    }
}
