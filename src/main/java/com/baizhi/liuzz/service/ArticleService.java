package com.baizhi.liuzz.service;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.entity.Article;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface ArticleService {
    //@LogAnnotation(description = "添加文章")
    public void addArticle(Article article);
    //@LogAnnotation(description = "查询文章")
    public List<Article> find(String id);
   // @LogAnnotation(description = "修改文章状态")
    public void modify(String id,String state);

}
