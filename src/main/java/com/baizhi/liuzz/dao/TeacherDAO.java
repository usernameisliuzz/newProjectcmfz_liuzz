package com.baizhi.liuzz.dao;

import com.baizhi.liuzz.entity.Teacher;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface TeacherDAO {
    public void insert(Teacher teacher);
    public void update(Teacher teacher);
    public List<Teacher> selectAll();
}
