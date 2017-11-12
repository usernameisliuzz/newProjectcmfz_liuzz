package com.baizhi.liuzz.controller;

import com.baizhi.liuzz.entity.Album;
import com.baizhi.liuzz.entity.Chapter;
import com.baizhi.liuzz.service.AlbumService;
import com.baizhi.liuzz.service.ChapterService;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("findchapter")
    @ResponseBody
    public List<Album> findchapter(){
        return albumService.findAll();
    }
    @RequestMapping("updateChapter")
    @ResponseBody
    public Map<String,Object> updateChapter(@RequestBody Chapter chapter){
        Map<String,Object> map=new HashMap<String, Object>();
        try {
            chapterService.modifyState(chapter.getCh_state(),chapter.getId());
            map.put("success", true);
            map.put("message","修改状态成功~~~");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }
    @RequestMapping("addchapter")
    @ResponseBody
    public Map<String,Object> addchapter(MultipartFile music, Chapter chapter, HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
            chapter.setName(music.getOriginalFilename());
            String newName= SnowflakeIdWorker.getSnowflakeId() +"."+
                    FilenameUtils.getExtension(music.getOriginalFilename());
            chapter.setCh_newName(newName);
            chapter.setCh_size(music.getSize()+"");
            String realpath=request.getRealPath("/upload");
            chapter.setCh_url(realpath);
            try {
            chapterService.addChapter(chapter);
            music.transferTo(new File(realpath+"/"+newName));
            map.put("success", true);
            map.put("message","音频上传成功~~~");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
            System.out.println(e.getMessage());
        }
        return map;
    }
    @RequestMapping("downMusic")
    public void downMusic(String fileName, HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        String realPath = request.getRealPath("/upload");
        FileInputStream fis = new FileInputStream(new File(realPath, fileName));
        response.setHeader("Content-Disposition","attachment;filename="+fileName);
        response.setContentType("audio/mpeg");
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(fis,os);
        IOUtils.closeQuietly(fis);
    }

}
