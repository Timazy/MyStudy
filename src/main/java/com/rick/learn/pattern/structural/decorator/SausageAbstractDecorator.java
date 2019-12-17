package com.rick.learn.pattern.structural.decorator;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
public class SausageAbstractDecorator extends AbstractDecorator{
    public SausageAbstractDecorator(AbstractPanCake abstractPanCake) {
        super(abstractPanCake);
    }

    @Override
    protected String getDes() {
        return super.getDes() + " one more sausage";
    }

    @Override
    protected Integer cost() {
        return super.cost() + 1;
    }
}
