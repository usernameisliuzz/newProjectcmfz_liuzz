package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.dao.TeacherDAO;
import com.baizhi.liuzz.entity.Teacher;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDAO teacherDAO;
    @LogAnnotation(description = "添加上师")
    public void addTeacher(Teacher teacher) {
        teacher.setId(SnowflakeIdWorker.getSnowflakeId()+"");
        teacherDAO.insert(teacher);
    }
    @LogAnnotation(description = "修改上师状态")
    public void modify(Teacher teacher) {
        teacherDAO.update(teacher);
    }
    //@LogAnnotation(description = "查询上师")
    public List<Teacher> findAll() {
        return teacherDAO.selectAll();
    }
}
