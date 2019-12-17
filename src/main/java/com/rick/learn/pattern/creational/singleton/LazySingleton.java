package com.rick.learn.pattern.creational.singleton;

/**
 * @author tianxiaobao@gegejia.com
 * @Description 懒汉单例
 * @Date 2019-12-14
 */
public class LazySingleton {

    private static LazySingleton singleton = null;

    //不能够完全防止攻击
    private LazySingleton(){
        if (singleton != null){
            throw new RuntimeException("reflect attach forbid");
        }
    }

    public static synchronized LazySingleton getInstance(){
        if (singleton == null){
            singleton = new LazySingleton();
        }
        return singleton;
    }

}
