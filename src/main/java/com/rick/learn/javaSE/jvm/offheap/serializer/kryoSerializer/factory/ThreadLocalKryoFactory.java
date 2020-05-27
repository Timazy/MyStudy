package com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.factory;

import com.esotericsoftware.kryo.Kryo;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-09
 */
public class ThreadLocalKryoFactory extends AbstractKryoFactory{

    private final ThreadLocal<Kryo> holder = ThreadLocal.withInitial(this::create);

    @Override
    public void returnKryo(Kryo kryo) {
        //do nothing
    }

    @Override
    public Kryo borrowKryo() {
        return holder.get();
    }
}
