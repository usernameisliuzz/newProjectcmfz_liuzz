package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.entity.Client;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface ClientService {
    public void addClient(Client client);
    //@LogAnnotation(description = "修改用户状态")
    public void modifyClient(Client client);
    //@LogAnnotation(description = "查询用户")
    public List<Client> findAll(Integer page,Integer rows,String phone);
    public Integer findCount();
    public List<Client> findDownClient();
}
