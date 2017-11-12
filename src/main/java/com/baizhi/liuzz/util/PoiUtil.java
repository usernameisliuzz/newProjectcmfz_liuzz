package com.baizhi.liuzz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import com.baizhi.liuzz.entity.User0;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PoiUtil {
    //文件导出
    public static void exportExcel(List data,Class clasz,OutputStream output) throws Exception {
        //创建excel对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建单页对象
        HSSFSheet sheet = wb.createSheet();
        //获取clasz对象中的所有属性
        Field[] fields = clasz.getDeclaredFields();
        System.out.println(fields);
        //创建表格第一行对象
        HSSFRow row1 = sheet.createRow(0);
        for (int i = 0; i <fields.length-2 ; i++) {
            //每个单元格填充数据
            System.out.println("1111111111111111");
            row1.createCell(i).setCellValue(fields[i].getName());
            System.out.println(fields[i].getName());
        }
        System.out.println(data.size());
        for (int i = 1; i <= data.size(); i++) {
            //依次创建行对象
            System.out.println("22222222222222");
            HSSFRow row = sheet.createRow(i);
            //依次获得date集合中的对象
            Object o = data.get(i - 1);
            System.out.println("333333333333");
            for (int j = 0; j < fields.length-2 ; j++) {
                //依次创建每行中的单元格对象
                HSSFCell cell = row.createCell(j);
                    Field field = fields[j];
                System.out.println(field);
                    //打破封装
                    field.setAccessible(true);
                System.out.println("4444444444444444");
                    //给单元格填充值     field.get(o)获得o对象相应属性的值
                    cell.setCellValue(field.get(o).toString());
                System.out.println(field.get(o).toString());
            }
        }
        System.out.println("/////////////");
        wb.write(output);
        output.close();
    }
    //文件导入
    public static List importExcel(FileInputStream in,Class clasz) throws IOException, IllegalAccessException, InstantiationException {
        HSSFWorkbook wb = new HSSFWorkbook(in);
        HSSFSheet sheet = wb.getSheetAt(0);
        ArrayList list = new ArrayList();
        //sheet.getLastRowNum 获得单页中所填充数据最后一行的下标（从0开始）
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            HSSFRow row = sheet.getRow(i);
            //用反射通过类对象创建对象
            Object o = clasz.newInstance();
            //获取对象中的所有属性
            Field[] fields = o.getClass().getDeclaredFields();
            //row.getLastCellNum 获取每行所填充数据最后一个单元格的下标
            for (int j = 0; j < row.getLastCellNum(); j++) {
                HSSFCell cell = row.getCell(j);
                Field field = fields[j];
                field.setAccessible(true);
                if(field.getType() == Integer.class){
                    field.set(o, new Integer(cell.toString()));
                } else{
                    //依据相应的属性设置相应的值
                    field.set(o,cell.toString());
                }
            }
            list.add(o);
        }
        return list;
    }
    /*public static void main(String[] args) throws Exception {

        //准备数据
        ArrayList<User0> users = new ArrayList<User0>();
        User0 user1 = new User0();
        user1.setId(1);
        user1.setUsername("徐浩志");
        user1.setPassword("123123");
        User0 user2 = new User0();
        user2.setId(2);
        user2.setUsername("徐浩志1");
        user2.setPassword("123123");
        User0 user3 = new User0();
        user3.setId(3);
        user3.setUsername("徐浩志2");
        user3.setPassword("123123");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        exportExcel(users, User0.class, "C://Users/Administrator/Desktop/new.xls");
    }
*/
}
