package com.rick.learn.pattern.creational.abstractfactory;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-10
 */
public class JavaVideo extends AbstractVideo {
    @Override
    public void produce() {
        System.out.println("java video");
    }
}
