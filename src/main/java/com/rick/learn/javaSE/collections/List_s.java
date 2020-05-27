package com.rick.learn.javaSE.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-05-06
 */
public class List_s {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            //concurrent control
            list.remove(next);
            System.out.println(iterator.next());
        }
    }

}
