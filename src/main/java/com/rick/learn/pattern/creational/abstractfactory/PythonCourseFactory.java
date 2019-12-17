package com.rick.learn.pattern.creational.abstractfactory;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-10
 */
public class PythonCourseFactory extends CourseFactory{
    @Override
    AbstractVideo getVideo() {
        return new PythonVideo();
    }

    @Override
    AbstractSource getSource() {
        return new PythonSource();
    }
}
