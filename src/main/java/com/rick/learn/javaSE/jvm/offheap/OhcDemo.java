package com.rick.learn.javaSE.jvm.offheap;

import org.caffinitas.ohc.CacheSerializer;
import org.caffinitas.ohc.OHCacheBuilder;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-01
 */
public class OhcDemo {


    public final static OHCacheBuilder ohc = OHCacheBuilder.newBuilder()
            .keySerializer(new CacheSerializer<Object>() {
            })


}
