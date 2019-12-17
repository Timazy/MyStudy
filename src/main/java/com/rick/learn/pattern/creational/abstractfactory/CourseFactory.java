package com.rick.learn.pattern.creational.abstractfactory;

/**
 * @author tianxiaobao@gegejia.com
 * @Description 相同产品族 java.sql.Statement
 * @Date 2019-12-10
 */
public abstract class CourseFactory {
    abstract AbstractVideo getVideo();
    abstract AbstractSource getSource();
}
