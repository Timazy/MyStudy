package com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer;

import com.esotericsoftware.kryo.Kryo;
import com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.factory.AbstractKryoFactory;
import com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.factory.ThreadLocalKryoFactory;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-09
 */
public class RickKryoUtils {

    public static AbstractKryoFactory kryoFactory = new ThreadLocalKryoFactory();

    public static Kryo borrow(){
        return kryoFactory.borrowKryo();
    }

    public static void release(Kryo kryo){
        kryoFactory.returnKryo(kryo);
    }


}
