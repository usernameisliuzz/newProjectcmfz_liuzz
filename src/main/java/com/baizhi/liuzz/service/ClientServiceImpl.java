package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.dao.ClientDAO;
import com.baizhi.liuzz.entity.Client;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDAO clientDAO;

    public void addClient(Client client) {
        client.setId(SnowflakeIdWorker.getSnowflakeId()+"");
        clientDAO.insert(client);
    }
    @LogAnnotation(description = "修改用户状态")
    public void modifyClient(Client client) {
        clientDAO.update(client);
    }
    //@LogAnnotation(description = "查询用户")
    public List<Client> findAll(Integer page,Integer rows,String phone) {
        return clientDAO.select(page,rows,phone);
    }

    public Integer findCount() {
        return clientDAO.selectCount();
    }

    public List<Client> findDownClient() {
        return clientDAO.selectDownClient();
    }
}
