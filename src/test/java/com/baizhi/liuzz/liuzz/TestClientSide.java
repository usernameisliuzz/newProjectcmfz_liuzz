package com.baizhi.liuzz.liuzz;

import com.baizhi.liuzz.entity.*;
import com.baizhi.liuzz.service.ClientSideService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */
public class TestClientSide extends BaseTest{
    @Autowired
    private ClientSideService clientSideService;
    @Test
    public void findAllAlbum(){
        List<Body> allAlbum = clientSideService.findAllAlbum();
        for(Body al:allAlbum){
            System.out.println(al);
        }
    }
    @Test
    public void findAllSlideShow(){
        List<Head> slideShows=clientSideService.findAllSlideShow();
        for(Head s:slideShows){
            System.out.println(s);
        }
    }
    @Test
    public void findAllArticle(){
        List<Body1> allArticle = clientSideService.findAllArticle();
        for(Body1 b1:allArticle){
            System.out.println(b1);
        }
    }
}
