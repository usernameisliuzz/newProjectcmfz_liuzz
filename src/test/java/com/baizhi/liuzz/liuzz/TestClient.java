package com.baizhi.liuzz.liuzz;

import com.baizhi.liuzz.entity.Client;
import com.baizhi.liuzz.service.ClientService;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public class TestClient extends BaseTest {
    @Autowired
    private ClientService clientService;
    @Test
    public void findAll(){
        List<Client> clients = clientService.findAll(2,2,null);
        System.out.println(clients);
        for(Client c : clients){
            System.out.println(c);
        }
    }
    @Test
    public void insert(){
       // Client client=new Client(SnowflakeIdWorker.getSnowflakeId()+"","2","222","222","222","22","2","2","2","374517952512262144","beijing",);
       //clientService.addClient(client);
    }
    @Test
    public void update(){
       // Client client=new Client("1","2","222","666","222","22","2","2","2","374517952512262144");
     //   clientService.modifyClient(client);
    }
    @Test
    public void findCount(){
        Integer count = clientService.findCount();
        System.out.println(count);
    }
    @Test
    public void findDownClient(){
        List<Client> downClient = clientService.findDownClient();
        for(Client c:downClient){
            System.out.println(c);
        }
    }
}
