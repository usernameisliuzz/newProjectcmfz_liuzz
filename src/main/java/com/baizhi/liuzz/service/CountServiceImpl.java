package com.baizhi.liuzz.service;

import com.baizhi.liuzz.dao.CountDAO;
import com.baizhi.liuzz.entity.Client;
import com.baizhi.liuzz.entity.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountServiceImpl implements CountService  {
    @Autowired
    private CountDAO countDAO;
    public Count findCount(String num) {
        return countDAO.select(num);
    }

    public Client getLongDate() {
        return countDAO.maxDate();
    }
}
