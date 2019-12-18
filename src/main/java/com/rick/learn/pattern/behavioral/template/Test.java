package com.rick.learn.pattern.behavioral.template;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-17
 */
public class Test {
    public static void main(String[] args) {
        Stream stream = new MyStream(true);
        stream.doStream();
    }
}
