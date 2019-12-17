package com.rick.learn.pattern.structural.adapter;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
public class TargetImpl implements Target{
    @Override
    public void request() {
        System.out.println("target impl");
    }
}
