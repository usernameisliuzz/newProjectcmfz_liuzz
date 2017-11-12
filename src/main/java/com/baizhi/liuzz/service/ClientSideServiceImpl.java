package com.baizhi.liuzz.service;

import com.baizhi.liuzz.dao.ClientSideDAO;
import com.baizhi.liuzz.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientSideServiceImpl implements ClientSideService {
    @Autowired
    private ClientSideDAO clientSideDAO;
    public List<Body> findAllAlbum() {
        return clientSideDAO.selectAllAlbum();
    }

    public List<Body1> findAllArticle() {
        return clientSideDAO.selectAllArticle();
    }

    public List<Head> findAllSlideShow() {
        return clientSideDAO.selectAllSlideShow();
    }
}
