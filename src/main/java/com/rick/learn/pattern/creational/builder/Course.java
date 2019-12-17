package com.rick.learn.pattern.creational.builder;

import lombok.Data;

/**
 * @author tianxiaobao@gegejia.com
 * @Description @see SqlSessionFactoryBuilder
 * @Date 2019-12-14
 */
@Data
public class Course {

    private String name;
    private String duration;

    public Course(CourseBuilder courseBuilder){
        this.name = courseBuilder.name;
        this.duration = courseBuilder.duration;
    }

    public Course(){}

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    //singleton
    public static class CourseBuilder extends Course {

        private String name;
        private String duration;

        public CourseBuilder buildName(String name){
            this.name = name;
            return this;
        }

        public CourseBuilder buildDuration(String duration){
            this.duration = duration;
            return this;
        }

        public Course build(){
            return new Course(this);
        }

    }

}
