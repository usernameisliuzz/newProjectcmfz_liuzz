package com.baizhi.liuzz.controller;

import com.baizhi.liuzz.entity.Client;
import com.baizhi.liuzz.service.ClientService;
import com.baizhi.liuzz.util.PoiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @RequestMapping("/findClient")
    @ResponseBody
    public Map<String,Object> findClient(Integer page,Integer rows){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Client> clients = clientService.findAll((page - 1)*rows, rows, null);
        Integer count = clientService.findCount();
        //System.out.println(count);
        map.put("total",count);
        map.put("rows",clients);
        return map;
    }
    @RequestMapping("/updateClient")
    public void updateClient(@RequestBody Client client){
        clientService.modifyClient(client);
    }

    @RequestMapping("/downClientMsg")
    public void downClientMsg() throws Exception {
        System.out.println("============");
        Integer count = clientService.findCount();
        List<Client> clients = clientService.findDownClient();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=studentMessages.xls");
        response.setContentType("application/msexcel");
        PoiUtil.exportExcel(clients,Client.class,output);
    }
}
