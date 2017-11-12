package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.entity.Chapter;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface ChapterService {
    //@LogAnnotation(description = "添加音频")
    public void addChapter(Chapter chapter);
    //@LogAnnotation(description = "修改音频状态")
    public void modifyState(String ch_state,String id);

}
