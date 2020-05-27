package com.rick.learn.javaSE.jvm.offheap.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-02
 */
@Getter
@Setter
public class MyObJ {

    private int value;
    private Long figure;
    private List<Integer> list;
    private SubOBJ sub;

    public MyObJ(int v){
        this.value = v;
    }

    public MyObJ(){
    }

}
