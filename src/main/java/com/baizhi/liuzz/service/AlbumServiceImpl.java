package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.dao.AlbumDAO;
import com.baizhi.liuzz.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDAO albumDAO;
    //@LogAnnotation(description = "查询所有的专辑")
    public List<Album> findAll() {
        return albumDAO.selectAll();
    }
}
