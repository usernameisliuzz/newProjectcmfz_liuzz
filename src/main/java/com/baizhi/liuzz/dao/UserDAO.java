package com.baizhi.liuzz.dao;

import com.baizhi.liuzz.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface UserDAO {
    public User selectByName(String name);
    public void update(@Param("newpw") String newpw, @Param("id") String id);
}
