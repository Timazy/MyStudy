package com.rick.learn.pattern.behavioral.chainOfResponsibility;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-18
 */
public abstract class AbstractApprover {
    protected AbstractApprover nextChain;

    public void nextHandler(AbstractApprover handler){
        this.nextChain = handler;
    }

    public abstract void approve(Course course);
}
