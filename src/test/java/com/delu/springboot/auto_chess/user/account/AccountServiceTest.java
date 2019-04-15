package com.delu.springboot.auto_chess.user.account;

import com.delu.springboot.autochess.user.account.Account;
import com.delu.springboot.autochess.user.account.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by delu on 2019-03-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void findOne() {

        String userId = "USER_L0rgxs";
        String accountStr = "963517096@qq.com";

//        Account account = accountService.findOne(userId, accountStr);

//        System.out.println(account);
    }
}