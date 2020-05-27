package com.rick.learn.spi;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-04
 */
public class MortyPerson implements Person{
    @Override
    public void hi() {
        System.out.println("hi i`m morty");
    }
}
