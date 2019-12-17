package com.rick.learn.pattern.structural.decorator;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
public class PanCake extends AbstractPanCake{

    @Override
    protected String getDes() {
        return "panCake";
    }

    @Override
    protected Integer cost() {
        return 1;
    }
}
