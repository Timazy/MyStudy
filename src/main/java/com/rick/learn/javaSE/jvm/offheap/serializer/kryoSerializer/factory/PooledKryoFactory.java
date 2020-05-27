package com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.factory;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.util.Pool;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-03
 */
public class PooledKryoFactory extends AbstractKryoFactory{

    public final static Pool<Kryo> kryoPool = new Pool<Kryo>(true,false,8) {
        @Override
        protected Kryo create() {
            Kryo kryo = new Kryo();
            //recycle reference open(default)
            kryo.setReferences(true);
            return kryo;
        }
    };


    @Override
    public void returnKryo(Kryo kryo) {
        kryoPool.free(kryo);
    }

    @Override
    public Kryo borrowKryo() {
        return kryoPool.obtain();
    }
}
