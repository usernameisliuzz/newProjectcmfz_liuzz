package com.baizhi.liuzz.liuzz;

import com.baizhi.liuzz.entity.Distribution;
import com.baizhi.liuzz.service.DistributionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
public class TestDistribution extends BaseTest {
    @Autowired
    private DistributionService distributionService;
    @Test
    public void distribution(){
        List<Distribution> list = distributionService.findAll();
        System.out.println(list);
        for(Distribution l:list){
            System.out.println(l);
        }
    }
}
