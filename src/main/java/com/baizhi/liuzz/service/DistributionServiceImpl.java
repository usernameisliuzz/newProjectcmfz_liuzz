package com.baizhi.liuzz.service;

import com.baizhi.liuzz.dao.DistributionDAO;
import com.baizhi.liuzz.entity.Distribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DistributionServiceImpl implements DistributionService {
    @Autowired
    private DistributionDAO distributionDAO;
    public List<Distribution> findAll() {
        return distributionDAO.select();
    }
}
