package com.delu.springboot;

import com.delu.springboot.autochess.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by delu on 2019-03-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){

        System.out.println("'" + null + "'");
    }
}
