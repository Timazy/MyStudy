package com.rick.learn.javaSE.Clazz.threadLocal;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-16
 */
public class Test {
    public static void main(String[] args) {

        Thread main = Thread.currentThread();
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("a");
    }
}
