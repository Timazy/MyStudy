package com.rick.learn.pattern.structural.bridge;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-17
 */
public class SavingAccount implements Account{

    @Override
    public Account openAccount() {
        System.out.println("open a saving account");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("this is a saving account");
    }
}
