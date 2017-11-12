package com.baizhi.liuzz.liuzz;

import com.baizhi.liuzz.entity.Menu;
import com.baizhi.liuzz.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class TestMenuSercie extends BaseTest {
    @Autowired
    private MenuService menuService;
    @Test
    public void TestFind(){
        List<Menu> menus=menuService.find();
        for(Menu m:menus){
            System.out.println(m);
        }
    }
}
