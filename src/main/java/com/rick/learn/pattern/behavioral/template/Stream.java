package com.rick.learn.pattern.behavioral.template;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-17
 */
public abstract class Stream {

    protected final void doStream(){
        doWork();
        doSleep();
        if (checkDoStudy()){
            doStudy();
        }
    }

    abstract void doWork();

    final void doSleep(){
        System.out.println("sleep");
    }

    final void doStudy(){
        System.out.println("study");
    }

    //钩子方法
    protected boolean checkDoStudy(){
        return false;
    }
}
