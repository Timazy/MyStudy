package com.rick.learn.pattern.structural.facade;

import lombok.Data;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
@Data
public class Gift {
    private String name;
    private Integer sku;

    public Gift(String name, Integer sku) {
        this.name = name;
        this.sku = sku;
    }
}
