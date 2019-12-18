package com.rick.learn.pattern.behavioral.template;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-17
 */
public class MyStream extends Stream{
    private boolean study = false;

    public MyStream(boolean study) {
        this.study = study;
    }

    @Override
    void doWork() {
        System.out.println("my works");
    }

    @Override
    protected boolean checkDoStudy() {
        return study;
    }
}
