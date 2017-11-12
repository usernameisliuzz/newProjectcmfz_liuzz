package com.baizhi.liuzz.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by Administrator on 2017/11/6.
 */
public class Md5Util1 {
    public static String getMd5Password(String password,String salt,int count){

        return new Md5Hash(password,salt,count).toString();
    }

    public static void main(String[] args) {
        String salt = CodeUtil.getCode(4);
        String md5Password = getMd5Password("123456", "aabb", 2);
        System.out.println(md5Password);

    }
}
