package com.baizhi.liuzz.service;

import com.baizhi.liuzz.entity.User;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface UserService {
    public User landing(String name);
    public void modify(String newpw,String id);
}
