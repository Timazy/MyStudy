package com.rick.learn.javaSE.Clazz.base;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-15
 */
public class LoadTest {

    public static int a = 10;

    static {
        System.out.println("-print-" + a);
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("com.rick.learn.javaSE.Clazz.base.LoadTest");
    }
}
