package com.delu.springboot.auto_chess.thirdpart;

import com.delu.springboot.autochess.thirdpart.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by delu on 2019-03-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisUtilsTest {

    @Autowired
    private RedisClient redisClient;

    @Test
    public void test() {

//        redisClient.set("hello", "delu", 10000);

        String hello = (String)redisClient.get("sku:stock:S00QZV196G");

        System.out.println(hello);
    }
}