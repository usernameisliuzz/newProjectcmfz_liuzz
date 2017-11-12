package com.baizhi.liuzz.dao;

import com.baizhi.liuzz.entity.Article;
import com.baizhi.liuzz.entity.Body;
import com.baizhi.liuzz.entity.Body1;
import com.baizhi.liuzz.entity.Head;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */
public interface ClientSideDAO {
    public List<Body> selectAllAlbum();
    public List<Body1> selectAllArticle();
    public List<Head> selectAllSlideShow();
}
