package com.rick.learn.pattern.structural.decorator;

/**
 * @author tianxiaobao@gegejia.com
 * @Description 可以作为抽象类 让其子类实现必要的方法
 * @Date 2019-12-15
 */
public class AbstractDecorator extends AbstractPanCake{

    private AbstractPanCake abstractPanCake;

    public AbstractDecorator(AbstractPanCake abstractPanCake){
        this.abstractPanCake = abstractPanCake;
    }

    @Override
    protected String getDes() {
        return abstractPanCake.getDes();
    }

    @Override
    protected Integer cost() {
        return abstractPanCake.cost();
    }
}
