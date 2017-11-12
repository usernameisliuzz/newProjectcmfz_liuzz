package com.baizhi.liuzz.controller;

import com.baizhi.liuzz.entity.SlideShow;
import com.baizhi.liuzz.service.SlideShowService;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/slideshow")
public class SlideShowController {
    @Autowired
    private SlideShowService slideShowService;

    @RequestMapping("/upSlideShow")
    @ResponseBody
    public Map<String,Object> upSlideShow(MultipartFile fi,SlideShow slideShow,HttpServletRequest request) throws Exception {
        SlideShow ss=new SlideShow();
        Map<String,Object> map = new HashMap<String, Object>();
        ss.setSli_name(fi.getOriginalFilename());
        String oldname= SnowflakeIdWorker.getSnowflakeId() +"."+
                FilenameUtils.getExtension(fi.getOriginalFilename());
        ss.setSli_oldname(oldname);
        ss.setSli_discription(slideShow.getSli_discription());
        ss.setState(slideShow.getState());
        ss.setSli_size(fi.getSize()+"");
        String realpath=request.getRealPath("/upload");
        ss.setSli_url(realpath+"/"+oldname);
        try {
            slideShowService.add(ss);
            fi.transferTo(new File(realpath+"/"+oldname));
            map.put("success", true);
            map.put("message","上传文件成功~~~");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @RequestMapping("/findSlideShow")
    @ResponseBody
    public List<SlideShow> findSlideShow(Integer page,Integer rows){
        List<SlideShow> slideShows=slideShowService.findAll();
        return slideShows;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map update(@RequestBody SlideShow slideShow){
        Map map = new HashMap<String,String>();
        try {
            map = slideShowService.modif(slideShow);
        }catch (Exception e){
            map.put("isError","true");
            map.put("msg","你没有权限修改~~~");
            e.printStackTrace();
        }
        System.out.println(map);
        return map;
    }


}
