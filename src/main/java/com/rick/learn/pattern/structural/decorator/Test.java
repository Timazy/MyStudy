package com.rick.learn.pattern.structural.decorator;

/**
 * @author tianxiaobao@gegejia.com
 * @Description 装饰者java io
 * @Date 2019-12-15
 */
public class Test {
    public static void main(String[] args) {

        AbstractPanCake abstractPanCake = new PanCake();
        abstractPanCake = new EggAbstractDecorator(abstractPanCake);
        abstractPanCake = new SausageAbstractDecorator(abstractPanCake);
        System.out.println(abstractPanCake.getDes()+" "+abstractPanCake.cost());
    }
}
