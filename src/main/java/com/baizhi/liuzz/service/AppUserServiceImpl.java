package com.baizhi.liuzz.service;

import java.io.UnsupportedEncodingException;

import com.baizhi.liuzz.util.CodeUtil;
import com.baizhi.liuzz.util.JedisUtil;
import com.baizhi.liuzz.util.Send;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;


@Service("appUserService")
public class AppUserServiceImpl  implements AppUserService {
    public void obtain(String phone) {
        //第一步产生随机码
        String code = CodeUtil.getCode(4);


        //第二步发送验证码
        try {
            String PostData = "account=liuzz1993&password=wan1993wan&mobile="+phone+"&content="+java.net.URLEncoder.encode("您的手机号：【"+phone+"】，注册验证码：【"+code+"】，一天内提交有效，如不是本人操作请忽略！","utf-8");
            //out.println(PostData);
            String ret = Send.SMS(PostData, "http://sms.106jiekou.com/utf8/sms.aspx");
            System.out.println(ret);
            if(ret.equals("100\n")){

                //进行验证码的redis存储
                Jedis jedis = JedisUtil.getJedis();
                jedis.select(1);
                jedis.setex(phone,300,code);

            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
