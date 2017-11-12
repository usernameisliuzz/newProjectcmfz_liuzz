package com.baizhi.liuzz.util;

/**
 * Created by Administrator on 2017/11/3.
 */

import java.util.Random;

/**
 *  随机码工具类
 */
public class CodeUtil {
    public static String getCode(int c){
        //定义一个字典
        String a = "ABCDEFGHIGK12345abcdefghigkm";

        //定义一个随机数
        Random random = new Random();

        //定义一个char 数组
        char[] b  = new char[c];

        for (int i = 0; i < b.length ; i++) {
            b[i] = a.charAt(random.nextInt(a.length()));
        }

        return new String(b);
    }

    public static void main(String[] args) {
        String code = getCode(12);
        System.out.println(code);
    }
}
