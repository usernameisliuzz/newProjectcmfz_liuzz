package com.baizhi.liuzz.dao;

import com.baizhi.liuzz.entity.Client;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface ClientDAO {
    public void insert(Client client);
    public void update(Client client);
    public List<Client> select(@Param("page") Integer page,@Param("rows") Integer rows,@Param("phone") String phone);
    public Integer selectCount();
    public List<Client> selectDownClient();
}
