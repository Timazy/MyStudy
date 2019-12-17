package com.rick.learn.pattern.creational.singleton;

import java.io.Serializable;

/**
 * @author tianxiaobao@gegejia.com
 * @Description 饿汉式
 * @Date 2019-12-14
 */
public class HungrySingleton implements Serializable {
    private final static HungrySingleton singleton = new HungrySingleton();

    //immutable
    private HungrySingleton(){
        if (singleton != null){
            throw new RuntimeException("reflect attach forbid");
        }
    }

    public static HungrySingleton getInstance(){
        return singleton;
    }

    //解决单例序列化问题,反射回来的时候调用
    public Object readResolve(){
        return singleton;
    }

}
