package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface AlbumService {
    //@LogAnnotation(description = "查询所有的专辑")
    public List<Album> findAll();
}
