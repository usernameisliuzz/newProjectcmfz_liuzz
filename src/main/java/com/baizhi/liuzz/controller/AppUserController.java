package com.baizhi.liuzz.controller;


import com.baizhi.liuzz.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/identify")
@Controller
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @RequestMapping("/obtain")
    public @ResponseBody void obtain(String phone){

        appUserService.obtain(phone);

    }
}
