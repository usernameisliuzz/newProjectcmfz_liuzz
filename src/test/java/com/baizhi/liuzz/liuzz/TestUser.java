package com.baizhi.liuzz.liuzz;


import com.baizhi.liuzz.entity.User;
import com.baizhi.liuzz.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/10/25.
 */
public class TestUser extends BaseTest {
    @Autowired
    private UserService userService;
    @Test
    public  void TestLanding(){
        User user=userService.landing("小王");
        System.out.println(user);
    }

    @Test
    public void modify(){
        userService.modify("123456","123123");
    }
}
