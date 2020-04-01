package com.rick.learn.javaSE.jvm.offheap.serializer;

import org.caffinitas.ohc.CacheSerializer;

import java.nio.ByteBuffer;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-01
 */
public class MyKeySerializer implements CacheSerializer {

    @Override
    public void serialize(Object value, ByteBuffer buf) {

    }

    @Override
    public Object deserialize(ByteBuffer buf) {
        return null;
    }

    @Override
    public int serializedSize(Object value) {
        return 0;
    }

}
