package com.rick.learn.javaSE.jvm.offheap.serializer;

import org.caffinitas.ohc.CacheSerializer;

import java.nio.ByteBuffer;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-30
 */
public class MyValueSerializer implements CacheSerializer<byte[]> {
    @Override
    public void serialize(byte[] value, ByteBuffer buf) {
        buf.put(value);
    }

    @Override
    public byte[] deserialize(ByteBuffer buf) {
        return buf.array();
    }

    @Override
    public int serializedSize(byte[] value) {
        return value.length;
    }
}
