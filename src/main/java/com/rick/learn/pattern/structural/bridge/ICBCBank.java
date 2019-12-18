package com.rick.learn.pattern.structural.bridge;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-17
 */
public class ICBCBank extends Bank {
    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        return account.openAccount();
    }
}
