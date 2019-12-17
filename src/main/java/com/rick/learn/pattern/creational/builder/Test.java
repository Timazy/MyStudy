package com.rick.learn.pattern.creational.builder;

/**
 * @author tianxiaobao@gegejia.com
 * @Description 建造者模式
 * @Date 2019-12-14
 */
public class Test {

    public static void main(String[] args) {
        Course course = new Course.CourseBuilder()
                .buildDuration("10")
                .buildName("java")
                .build();
        System.out.println(course);
    }

}
