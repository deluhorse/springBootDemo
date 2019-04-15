package com.delu.springboot.autochess.user.account;

import com.delu.springboot.autochess.user.account.dto.AccountDaoBaseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by delu on 2019-03-29.
 */
@Mapper
public interface AccountDao {

    @SelectProvider(type = AccountSqlBuilder.class, method = "insert")
    void insertAccount(Account account);

    @SelectProvider(type = AccountSqlBuilder.class, method = "findOne")
    Account findOne(AccountDaoBaseDto accountDaoBaseDto);
}
