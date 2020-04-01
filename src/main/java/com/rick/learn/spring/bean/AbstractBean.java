package com.rick.learn.spring.bean;

import javax.annotation.PostConstruct;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-13
 */

public abstract class AbstractBean{



    public abstract void load();

    @PostConstruct
    public void init(){
        System.out.println("--init--");
    }

}
