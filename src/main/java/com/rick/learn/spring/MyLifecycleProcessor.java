package com.rick.learn.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-04
 */
@Configuration
public class MyLifecycleProcessor implements BeanPostProcessor {



    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Lifecycle){
            System.out.println("LifecycleProcessor.postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Lifecycle){
            System.out.println("LifecycleProcessor.postProcessAfterInitialization");
        }
        return bean;
    }


    @Bean(initMethod = "init",destroyMethod = "customDestroy")
    public Lifecycle getLifecycle(){
        Lifecycle lifecycle = new Lifecycle();
        return lifecycle;
    }

}
