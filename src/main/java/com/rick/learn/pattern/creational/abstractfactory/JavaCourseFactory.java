package com.rick.learn.pattern.creational.abstractfactory;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-10
 */
public class JavaCourseFactory extends CourseFactory{
    @Override
    AbstractVideo getVideo() {
        return new JavaVideo();
    }

    @Override
    AbstractSource getSource() {
        return new JavaSource();
    }
}
