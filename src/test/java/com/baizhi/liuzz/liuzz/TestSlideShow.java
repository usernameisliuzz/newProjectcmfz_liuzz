package com.baizhi.liuzz.liuzz;

import com.baizhi.liuzz.entity.SlideShow;
import com.baizhi.liuzz.service.SlideShowService;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public class TestSlideShow  extends BaseTest{
    @Autowired
    private SlideShowService slideShowService;
    @Test
    public void TestAdd(){
       SlideShow slideShow =new SlideShow("","aa","44","ss","66","true","1.22");
        slideShowService.add(slideShow);
    }
    @Test
    public void TestFindBy(){
       // SlideShow slideShow = slideShowService.findBy("373116436630994944",null);
        //SlideShow slideShow = slideShowService.findBy(null,null);
        List<SlideShow> slideShows = slideShowService.findAll();
        System.out.println(slideShows);
    }
    @Test
    public void update(){
        SlideShow slideShow =new SlideShow("373262126183088128","111","111","111","111","true","1.22");
        slideShowService.modif(slideShow);
    }

}
