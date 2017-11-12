package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.entity.Teacher;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface TeacherService {
    //@LogAnnotation(description = "添加上师")
    public void addTeacher(Teacher teacher);
    //@LogAnnotation(description = "修改上师状态")
    public void modify(Teacher teacher);
    //@LogAnnotation(description = "查询上师")
    public List<Teacher> findAll();
}
