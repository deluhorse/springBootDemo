package com.delu.springboot.autochess.user;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created by delu on 2019-03-29.
 */
public class UserSqlBuilder {

    public static String insert(){

        return new SQL(){{

            INSERT_INTO("tbl_um_user");
            INTO_COLUMNS("user_id", "account", "password", "salt");
            INTO_VALUES("#{userId}", "#{account}", "#{password}", "#{salt}");
        }}.toString();
    }
}
