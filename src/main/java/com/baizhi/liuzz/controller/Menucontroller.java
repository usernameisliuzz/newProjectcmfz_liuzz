package com.baizhi.liuzz.controller;


import com.baizhi.liuzz.entity.Menu;
import com.baizhi.liuzz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("menu")
public class Menucontroller {
    @Autowired
    private MenuService menuService;

    @RequestMapping("find")
    @ResponseBody
    public List<Menu> find(){
        List<Menu> menus = menuService.find();
        return menus;
    }

}
