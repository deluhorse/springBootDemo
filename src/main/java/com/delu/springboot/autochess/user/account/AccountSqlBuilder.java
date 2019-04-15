package com.delu.springboot.autochess.user.account;

import com.delu.springboot.autochess.tools.CommonUtils;
import com.delu.springboot.autochess.tools.SqlUtils;
import com.delu.springboot.autochess.user.account.dto.AccountDaoBaseDto;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by delu on 2019-03-29.
 */
public class AccountSqlBuilder {

    /**
     * 创建单条纪录
     * @param account
     * @return
     */
    public static String insert(Account account){

        return new SQL(){{
            INSERT_INTO("tbl_um_account");
            INTO_COLUMNS("user_id", "account", "password", "salt");
            INTO_VALUES(
                    SqlUtils.formatField(account.getUserId()),
                    SqlUtils.formatField(account.getAccount()),
                    SqlUtils.formatField(account.getPassword()),
                    SqlUtils.formatField(account.getSalt())
            );
        }}.toString();
    }

    /**
     * 查询单个帐户
     * @param accountDaoBaseDto
     * @return
     */
    public static String findOne(AccountDaoBaseDto accountDaoBaseDto){

        return new SQL(){{
            SELECT("user_id", "account", "password", "salt");
            FROM("tbl_um_account");
            if (!CommonUtils.isEmpty(accountDaoBaseDto.getUserId())){
                WHERE(" user_id = " + SqlUtils.formatField(accountDaoBaseDto.getUserId()));
            }

            if (!CommonUtils.isEmpty(accountDaoBaseDto.getAccount())){
                WHERE(" account = " + SqlUtils.formatField(accountDaoBaseDto.getAccount()));
            }
        }}.toString();
    }
}
