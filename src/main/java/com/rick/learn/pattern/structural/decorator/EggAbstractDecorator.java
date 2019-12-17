package com.rick.learn.pattern.structural.decorator;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
public class EggAbstractDecorator extends AbstractDecorator{
    public EggAbstractDecorator(AbstractPanCake abstractPanCake) {
        super(abstractPanCake);
    }

    @Override
    protected String getDes() {
        return super.getDes() + " one more egg";
    }

    @Override
    protected Integer cost() {
        return super.cost() + 2;
    }
}
