package com.baizhi.liuzz.dao;

import com.baizhi.liuzz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface ArticleDAO {
    public void insert(Article article);
    public List<Article> select(@Param("tea_id") String tea_id);
    public void update(@Param("id") String id,@Param("state") String state);
}
