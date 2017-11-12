package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.entity.SlideShow;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface SlideShowService {
    public void add(SlideShow slideShow);
    public SlideShow findBy(String id,String state);
   // @LogAnnotation(description = "查看轮播图")
    public List<SlideShow> findAll();
    //@LogAnnotation(description = "修改轮播图状态")
    public Map modif(SlideShow slideShow);
}
