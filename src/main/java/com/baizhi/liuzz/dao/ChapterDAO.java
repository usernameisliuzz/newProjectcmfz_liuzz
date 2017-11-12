package com.baizhi.liuzz.dao;

import com.baizhi.liuzz.entity.Chapter;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface ChapterDAO {
    public void insert(Chapter chapter);
    public void update(String ch_state,String id);
}
