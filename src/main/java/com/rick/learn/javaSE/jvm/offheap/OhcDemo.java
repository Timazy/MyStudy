package com.rick.learn.javaSE.jvm.offheap;

import com.rick.learn.javaSE.jvm.offheap.entity.MyObJ;
import com.rick.learn.javaSE.jvm.offheap.serializer.MyKeySerializer;
import lombok.Data;
import org.caffinitas.ohc.CacheSerializer;
import org.caffinitas.ohc.OHCache;
import org.caffinitas.ohc.OHCacheBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-01
 */
public class OhcDemo {


    public final static OHCache ohc = OHCacheBuilder.newBuilder()
            //.keySerializer(new MyKeySerializer())
            .valueSerializer(new CacheSerializer<Object>() {
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
            })
            .build();


    public static void main(String[] args) {
        try {
            System.in.read();
            System.out.println(getLong(null,null));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Data
    public static class TT{
        public long a;

    }

    public static Long getLong( TT t,Long a) {

        return t == null ? a : t.getA();

    }




}
