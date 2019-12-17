package com.rick.learn.pattern.structural.adapter.classadapter;

import com.rick.learn.pattern.structural.adapter.Adaptee;
import com.rick.learn.pattern.structural.adapter.Target;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        //..more
        super.adapteeRequest();
        //..more
    }
}
