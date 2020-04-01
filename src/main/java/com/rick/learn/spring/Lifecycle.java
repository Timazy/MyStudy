package com.rick.learn.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-04
 */
public class Lifecycle implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    static {
        System.out.println("static block");
    }

    public Lifecycle() {
        System.out.println("bean construct");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("implements BeanNameAware called setBeanName = "+name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("implements BeanFactoryAware called setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("implements ApplicationContextAware called setApplicationContext");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("implements InitializingBean called afterPropertiesSet");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("post construct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("post destroy");
    }

    public void init(){
        System.out.println("init method");
    }

    public void customDestroy(){
        System.out.println("custom destroy");
    }

    @Override
    public void destroy(){
        System.out.println("implements DisposableBean called destroy");
    }
}
