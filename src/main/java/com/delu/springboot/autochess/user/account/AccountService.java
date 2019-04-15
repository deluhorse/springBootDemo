package com.delu.springboot.autochess.user.account;

import com.delu.springboot.autochess.base.BaseService;
import com.delu.springboot.autochess.user.account.dto.AccountDaoBaseDto;
import com.delu.springboot.autochess.user.account.dto.AccountServiceBaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by delu on 2019-03-29.
 */
@Service
public class AccountService extends BaseService {

    @Autowired
    private AccountDao accountDao;

    public Account findOne(AccountServiceBaseDto accountServiceBaseDto){

        AccountDaoBaseDto accountDaoBaseDto = dozerMapper.map(accountServiceBaseDto, AccountDaoBaseDto.class);

        return accountDao.findOne(accountDaoBaseDto);
    }
}