package com.baizhi.liuzz.liuzz;

import com.baizhi.liuzz.entity.Teacher;
import com.baizhi.liuzz.service.TeacherService;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public class TestTeacher extends BaseTest {
    @Autowired
    private TeacherService teacherService;
    @Test
    public void Insert(){
        Teacher teacher=new Teacher(SnowflakeIdWorker.getSnowflakeId()+"","扎西得勒","qq/qq","true");
        teacherService.addTeacher(teacher);
    }
    @Test
    public void update(){
        Teacher teacher=new Teacher("374517952512262144","卓玛","qq/qq","false");
        teacherService.modify(teacher);
    }
    @Test
    public void selectAll(){
        List<Teacher> teachers = teacherService.findAll();
        for(Teacher t:teachers){
            System.out.println(t);
        }
    }

}
