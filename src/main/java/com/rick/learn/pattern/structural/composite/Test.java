package com.rick.learn.pattern.structural.composite;

/**
 * @author tianxiaobao@gegejia.com
 * @Description 适用于树形结构 让上层不区分叶子和根 但是如果有根上对叶子的判断逻辑 就麻烦
 * @Date 2019-12-15
 */
public class Test {
    public static void main(String[] args) {
        AbstractCategoryComponent mainDic = new Dictionary("主目录","level 1");

        AbstractCategoryComponent javaCategoryDic = new Dictionary("java dic","level 2");
        AbstractCategoryComponent designFile = new File("design",1,"design mode");
        AbstractCategoryComponent threadFile = new File("thread",1,"thread");

        javaCategoryDic.add(designFile);
        javaCategoryDic.add(threadFile);
        mainDic.add(javaCategoryDic);
        mainDic.print();
    }
}
