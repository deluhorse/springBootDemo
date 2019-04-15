package com.delu.springboot.auto_chess.base;

import com.delu.springboot.autochess.user.account.dto.AccountDaoBaseDto;
import com.delu.springboot.autochess.user.account.dto.AccountServiceBaseDto;
import org.dozer.Mapper;
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
public class DozerTest {

    @Autowired
    private Mapper dozerMapper;

    @Test
    public void test() {

        AccountServiceBaseDto accountServiceBaseDto = new AccountServiceBaseDto();

        accountServiceBaseDto.setUserId("123");
        accountServiceBaseDto.setAccount("456");

        AccountDaoBaseDto accountDaoBaseDto = dozerMapper.map(accountServiceBaseDto, AccountDaoBaseDto.class);

        System.out.println(accountDaoBaseDto);
    }
}