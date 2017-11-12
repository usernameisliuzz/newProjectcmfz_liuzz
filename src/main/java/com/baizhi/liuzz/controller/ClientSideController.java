package com.baizhi.liuzz.controller;

import com.baizhi.liuzz.entity.Body;
import com.baizhi.liuzz.entity.Body1;
import com.baizhi.liuzz.entity.Head;
import com.baizhi.liuzz.entity.SlideShow;
import com.baizhi.liuzz.service.ClientSideService;
import com.baizhi.liuzz.service.SlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cmfz")
public class ClientSideController {
    @Autowired
    private ClientSideService clientSideService;

    @RequestMapping("first_page")
    @ResponseBody
    public Map<String,Object> first_page(String uid,String type,String sub_type){
        Map<String,Object> map = new HashMap<String, Object>();
        if(type.equals("all")){
            List<Head> allSlideShow = clientSideService.findAllSlideShow();
            map.put("header",allSlideShow);
        }
        if(type.equals("wen")){
            List<Body> allAlbum = clientSideService.findAllAlbum();
            map.put("body",allAlbum);
        }
        if(type.equals("si")){
            List<Body1> allArticle = clientSideService.findAllArticle();
            map.put("body",allArticle);
        }
        return map;
    }
}
