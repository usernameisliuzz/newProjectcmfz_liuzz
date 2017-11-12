package com.baizhi.liuzz.service;



import com.baizhi.liuzz.dao.MenuDAO;
import com.baizhi.liuzz.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl  implements MenuService {
    @Autowired
    private MenuDAO menuDAO;
    public List<Menu> find() {
        return menuDAO.select();
    }
}
