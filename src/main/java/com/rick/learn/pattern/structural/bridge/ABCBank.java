package com.rick.learn.pattern.structural.bridge;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-17
 */
public class ABCBank extends Bank{
    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        return null;
    }


}
