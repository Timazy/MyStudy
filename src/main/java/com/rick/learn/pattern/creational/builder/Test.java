package com.rick.learn.pattern.creational.builder;

/**
 * @author tianxiaobao@gegejia.com
 * @Description 建造者模式
 * @Date 2019-12-14
 */
public class Test {

    public static void main(String[] args) {
        /*Course.CourseBuilder course = new Course.CourseBuilder()
                .buildDuration("10")
                .buildName("java");
        Course course2 = new Course.CourseBuilder()
                .buildDuration("20")
                .build();
        Course course1 = course.build();
        System.out.println(course1);
        System.out.println(course2);*/


        Course.CourseBuilder builder = new Course.CourseBuilder()
                .buildDuration("10");


        Course course2 = new Course.CourseBuilder()
                .buildName("java")
                .build();

        Course course = builder
                .buildName("python")
                .build();
        System.out.println(course);
        System.out.println(course2);
    }

}
