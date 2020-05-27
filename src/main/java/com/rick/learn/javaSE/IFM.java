package com.rick.learn.javaSE;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-05-06
 */
public class IFM {

    public static void main(String[] args) {
        Integer v = 1;
        if (v == 1){
            System.out.println("v == 1");
        }else if (v instanceof Object){
            System.out.println("v == object");
        }

        Map<String,Object> map = new HashMap();
        map.put(null,1);

        //LongAdder
        Integer a = null;
        System.out.println(1 == a);

    }

    private static ConcurrentHashMap<String,Integer> counter = new ConcurrentHashMap<>();

    public void inc(String key){
        Integer v = counter.putIfAbsent(key,1);
        if (v != null){
            synchronized (counter.get(key)){
                counter.put(key,counter.get(key));
            }
        }
    }

}
