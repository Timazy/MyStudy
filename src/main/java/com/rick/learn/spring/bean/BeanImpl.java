package com.rick.learn.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-13
 */
@Component
public class BeanImpl extends AbstractBean{



    @Override
    public void load() {
        System.out.println("--load--");
    }

    @PostConstruct
    public void subInit(){
        System.out.println("--subInit--");
    }

}
