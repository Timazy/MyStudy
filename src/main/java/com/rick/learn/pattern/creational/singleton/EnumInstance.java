package com.rick.learn.pattern.creational.singleton;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-14
 */
public enum  EnumInstance {
    INSTANCE;

    public Object object;

    public EnumInstance getEnum(){
        return INSTANCE;
    }

}
