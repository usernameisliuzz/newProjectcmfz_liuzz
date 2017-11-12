package com.baizhi.liuzz.service;


import com.baizhi.liuzz.entity.*;


import java.util.List;


public interface ClientSideService {
    public List<Body> findAllAlbum();
    public List<Body1> findAllArticle();
    public List<Head> findAllSlideShow();
}
