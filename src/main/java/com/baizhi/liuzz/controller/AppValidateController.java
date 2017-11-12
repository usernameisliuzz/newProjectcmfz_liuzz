package com.baizhi.liuzz.controller;

import com.baizhi.liuzz.util.JedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("identify")
public class AppValidateController {


    @RequestMapping("check")
    public Map<String,String> CodeValidate(String phone,String code){
        Map<String,String> map = new HashMap<String, String>();
        Jedis jedis = JedisUtil.getJedis();
        jedis.select(1);
        String s = jedis.get(phone);
        if(s.equals(code)){
            map.put("result","success");
        }else{
            map.put("result","fail");
        }

        return map;
    }
}
