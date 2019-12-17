package com.rick.learn.pattern.structural.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
@Data
public class Dictionary extends AbstractCategoryComponent{
    private String name;
    private String des;
    private List<AbstractCategoryComponent> files = new ArrayList<>();

    public Dictionary(String name, String des) {
        this.name = name;
        this.des = des;
    }

    @Override
    protected String getName(AbstractCategoryComponent categoryComponent){
        return this.getName();
    }

    @Override
    protected void print() {
        System.out.println("name"+name+" des:"+des);
        for (AbstractCategoryComponent file : files){
            file.print();
        }
    }

    @Override
    protected void add(AbstractCategoryComponent categoryComponent) {
        files.add(categoryComponent);
    }

    @Override
    protected void remove(AbstractCategoryComponent categoryComponent) {
        files.remove(categoryComponent);
    }
}
