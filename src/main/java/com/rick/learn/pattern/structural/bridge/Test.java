package com.rick.learn.pattern.structural.bridge;

/**
 * @author tianxiaobao@gegejia.com
 * @Description 组合替代继承 设计到两种维度以上的多组合的 用这个
 * @Date 2019-12-17
 */
public class Test {
    public static void main(String[] args) {
        Bank bank = new ABCBank(new SavingAccount());
        Account account = bank.openAccount();
        account.showAccountType();
    }
}
