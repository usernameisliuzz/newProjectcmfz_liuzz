package com.baizhi.liuzz.dao;

import com.baizhi.liuzz.entity.Client;
import com.baizhi.liuzz.entity.Count;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface CountDAO {
    public Count select(String num);
    public Client maxDate();
}
