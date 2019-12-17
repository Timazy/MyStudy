package com.rick.learn.pattern.creational.singleton;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-14
 */
public class StaticInnerClassSingleton {

    //immutable
    private StaticInnerClassSingleton(){
        if (InnerClass.singleton != null){
            throw new RuntimeException("reflect attach forbid");
        }
    }

    private static class InnerClass{
        private static StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }


    public static StaticInnerClassSingleton getInstance(){
        //类中的属性方法、成员变量被调用，类锁并立刻初始化，singleton被赋值
        return InnerClass.singleton;
    }
}
