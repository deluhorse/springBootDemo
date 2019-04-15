package com.delu.springboot.autochess.user.account.dto;

/**
 * Created by delu on 2019-03-29.
 */
public class AccountServiceBaseDto {

    private String userId;

    private String account;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
