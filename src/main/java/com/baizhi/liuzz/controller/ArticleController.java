package com.baizhi.liuzz.controller;

import com.baizhi.liuzz.entity.Article;
import com.baizhi.liuzz.service.ArticleService;
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
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("findArticle")
    @ResponseBody
    public List<Article> findArticle(){
        return articleService.find(null);
    }
    @RequestMapping("updateArticle")
    public void updateArticle(@RequestBody Article article){
        articleService.modify(article.getId(),article.getState());
    }
    @RequestMapping("upPicture")
    @ResponseBody
    public Map<String,Object> upPicture(MultipartFile image, HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        String oldname= SnowflakeIdWorker.getSnowflakeId() +"."+
                FilenameUtils.getExtension(image.getOriginalFilename());
        String realpath=request.getRealPath("/upload");
        String resultpath=realpath+"/"+oldname;
        try {
            image.transferTo(new File(resultpath));
            map.put("error", 0);
            map.put("url","/cmfz_liuzz/upload/"+oldname);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error", 1);
            map.put("message", "文章添加失败！！！");
            System.out.println(e.getMessage());
        }
        return map;
    }
    @RequestMapping("addArticle")
    @ResponseBody
    public Map<String,Object> addArticle(Article article,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        String realpath=request.getRealPath("/upload");
        article.setAddr_picture(realpath);
            System.out.println(article);
            try {
                articleService.addArticle(article);
                map.put("success", true);
                map.put("message","上传文件成功~~~");
            } catch (Exception e) {
                e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }
}
