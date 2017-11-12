package com.baizhi.liuzz.controller;

import com.baizhi.liuzz.entity.Teacher;
import com.baizhi.liuzz.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @RequestMapping("findTeacher")
    @ResponseBody
    public List<Teacher> findTeacher(){
        return teacherService.findAll();
    }
    @RequestMapping("update")
    public void update(@RequestBody Teacher teacher){
        System.out.println(teacher);
        teacherService.modify(teacher);
    }
    @RequestMapping("addTeacher")
    @ResponseBody
    public Map<String,Object> addTeacher(Teacher teacher){
        Map<String,Object> map=new HashMap<String, Object>();
        try {
            teacherService.addTeacher(teacher);
            map.put("success", true);
            map.put("message","上师添加成功~~~");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "上师添加失败！！！");
            System.out.println(e.getMessage());
        }
        return map;
    }
}
