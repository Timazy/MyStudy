package com.rick.learn.pattern.structural.bridge;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-16
 */
public abstract class Bank {
    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();

}
