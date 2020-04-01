package com.rick.learn.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-13
 */
@Component
public class BeanImpl2 extends AbstractBean  implements ApplicationContextAware {

    @Override
    public void load() {
        System.out.println("--2load--");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("implements ApplicationContextAware called setApplicationContext");
    }
}
