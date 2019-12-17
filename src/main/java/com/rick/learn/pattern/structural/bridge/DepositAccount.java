package com.rick.learn.pattern.structural.bridge;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-17
 */
public class DepositAccount implements Account{
    @Override
    public Account openAccount() {
        System.out.println("open a deposit account");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("this is a deposit account");
    }
}
