package com.baizhi.liuzz.dao;

import com.baizhi.liuzz.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface AlbumDAO {
    public List<Album> selectAll();
}
