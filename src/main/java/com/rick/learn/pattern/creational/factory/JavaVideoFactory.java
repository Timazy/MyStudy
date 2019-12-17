package com.rick.learn.pattern.creational.factory;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-10
 */
public class JavaVideoFactory extends VideoFactory{
    @Override
    public AbstractVideo buildVideo() {
        return new JavaVideo();
    }
}
