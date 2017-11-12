package com.baizhi.liuzz.service;

import com.baizhi.liuzz.dao.UserDAO;
import com.baizhi.liuzz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserDAO userDAO;
    public User landing(String name) {
        return userDAO.selectByName(name);
    }

    public void modify(String newpw, String id) {
        userDAO.update(newpw,id);
    }
}
