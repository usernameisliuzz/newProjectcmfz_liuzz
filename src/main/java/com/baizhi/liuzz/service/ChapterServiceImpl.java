package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.dao.ChapterDAO;
import com.baizhi.liuzz.entity.Chapter;
import com.baizhi.liuzz.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService{
    @Autowired
    private ChapterDAO chapterDAO;
    @LogAnnotation(description = "添加音频")
    public void addChapter(Chapter chapter) {
        chapter.setId(SnowflakeIdWorker.getSnowflakeId()+"");
        chapterDAO.insert(chapter);
    }
    @LogAnnotation(description = "修改音频状态")
    public void modifyState(String ch_state, String id) {
        chapterDAO.update(ch_state, id);
    }
}
