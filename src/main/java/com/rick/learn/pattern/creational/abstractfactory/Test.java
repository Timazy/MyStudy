package com.rick.learn.pattern.creational.abstractfactory;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-10
 */
public class Test {

    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        AbstractSource source = courseFactory.getSource();
        AbstractVideo video = courseFactory.getVideo();
        source.produce();
        video.produce();
    }

}
