package com.delu.springboot.autochess.user.login;

import com.delu.springboot.autochess.user.account.Account;
import com.delu.springboot.autochess.user.UserService;
import com.delu.springboot.autochess.user.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by delu on 2019-03-29.
 */
@Service
public class LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    public Boolean login(String userName, String password){

        // 1 根据userName 查询帐户信息
//        Account account =


        // 2 比较帐户密码

        // 3 返回登录结果

        return true;
    }
}
