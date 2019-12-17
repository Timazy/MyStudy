package com.rick.learn.pattern.structural.composite;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
public abstract class AbstractCategoryComponent {


    protected String getName(AbstractCategoryComponent categoryComponent) {
        throw new UnsupportedOperationException("unsupported getName");
    }
    protected double getPrice(AbstractCategoryComponent categoryComponent) {
        throw new UnsupportedOperationException("unsupported getPrice");
    }
    protected void print() {
        throw new UnsupportedOperationException("unsupported print");
    }
    protected void add(AbstractCategoryComponent categoryComponent){
        throw new UnsupportedOperationException("unsupported add");
    }
    protected void remove(AbstractCategoryComponent categoryComponent){
        throw new UnsupportedOperationException("unsupported remove");
    }
}
