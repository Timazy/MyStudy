package com.rick.learn.pattern.structural.composite;

import lombok.Data;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
@Data
public class File extends AbstractCategoryComponent {
    private String name;
    private double price;
    private String des;

    public File(String name, double price, String des) {
        this.name = name;
        this.price = price;
        this.des = des;
    }

    @Override
    protected String getName(AbstractCategoryComponent categoryComponent) {
        return this.getName();
    }

    @Override
    protected void print(){
        System.out.println("name:"+name+" price:"+price + " des:"+des);
    }

    @Override
    protected double getPrice(AbstractCategoryComponent categoryComponent) {
        return this.getPrice();
    }
}
