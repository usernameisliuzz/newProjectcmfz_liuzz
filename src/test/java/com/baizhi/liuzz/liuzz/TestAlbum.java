package com.baizhi.liuzz.liuzz;

import com.baizhi.liuzz.entity.Album;
import com.baizhi.liuzz.service.AlbumService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public class TestAlbum extends BaseTest{
    @Autowired
    private AlbumService albumService;

    @Test
    public void findAlbum(){
        List<Album> albums=albumService.findAll();
        for(Album a:albums){
            System.out.println(a);
        }
    }

}
