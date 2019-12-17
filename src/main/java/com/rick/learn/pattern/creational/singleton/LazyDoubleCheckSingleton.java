package com.rick.learn.pattern.creational.singleton;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-14
 */
public class LazyDoubleCheckSingleton {

    private static volatile LazyDoubleCheckSingleton singleton = null;

    //不能够完全防止攻击
    private LazyDoubleCheckSingleton(){
        if (singleton != null){
            throw new RuntimeException("reflect attach forbid");
        }
    }

    public static synchronized LazyDoubleCheckSingleton getInstance(){
        if (singleton == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (singleton == null){
                    singleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }


}
