package com.baizhi.liuzz.service;

import com.baizhi.liuzz.entity.Client;
import com.baizhi.liuzz.entity.Count;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface CountService {
    public Count findCount(String num);
    public Client getLongDate();
}
