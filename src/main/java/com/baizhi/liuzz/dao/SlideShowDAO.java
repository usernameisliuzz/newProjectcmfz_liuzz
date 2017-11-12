package com.baizhi.liuzz.dao;

import com.baizhi.liuzz.entity.SlideShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface SlideShowDAO {
    public void insert(SlideShow slideShow);
    public SlideShow selectBy(@Param("id") String id, @Param("state") String state);
    public List<SlideShow> selectAll();
    public void update(SlideShow slideShow);
}
