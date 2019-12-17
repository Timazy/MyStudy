package com.rick.learn.pattern.creational.factory;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-08
 */
public class Test {

    public static void main(String[] args) {
        VideoFactory factory = new JavaVideoFactory();
        AbstractVideo video = factory.buildVideo();
        video.produce();
    }

}
