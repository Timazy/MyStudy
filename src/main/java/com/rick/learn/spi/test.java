package com.rick.learn.spi;

import java.util.ServiceLoader;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-04
 */
public class test {

    public static void main(String[] args) {

        ServiceLoader<Person> serviceLoader = ServiceLoader.load(Person.class);
        System.out.println("person apis");
        serviceLoader.forEach(Person::hi);

    }
}
