package com.rick.learn.pattern.structural.adapter.objectadapter;

import com.rick.learn.pattern.structural.adapter.Adaptee;
import com.rick.learn.pattern.structural.adapter.Target;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
public class Adapter implements Target{
    private Adaptee adaptee = new Adaptee();
    @Override
    public void request() {
        //..more
        adaptee.adapteeRequest();
        //..more
    }
}
