package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.dao.SlideShowDAO;
import com.baizhi.liuzz.entity.SlideShow;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SlideShowServiceImpl implements SlideShowService{
    @Autowired
    private SlideShowDAO slideShowDAO;
    @LogAnnotation(description = "添加轮播图")
    public void add(SlideShow slideShow) {
        slideShow.setSli_id(SnowflakeIdWorker.getSnowflakeId()+"");
        slideShowDAO.insert(slideShow);
    }

    public SlideShow findBy(String id, String state) {
        return slideShowDAO.selectBy(id,state);
    }
    //@LogAnnotation(description = "查看轮播图")
    public List<SlideShow> findAll() {
        return slideShowDAO.selectAll();
    }

    @LogAnnotation(description = "修改轮播图状态")
    @RequiresRoles("superAdmin")
    public Map modif(SlideShow slideShow) {
        HashMap<String, String> map = new HashMap<String, String>();
        slideShowDAO.update(slideShow);
        return map;
    }
}
