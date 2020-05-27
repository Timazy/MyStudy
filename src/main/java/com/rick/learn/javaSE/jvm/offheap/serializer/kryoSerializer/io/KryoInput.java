package com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.io;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.RickKryoUtils;

import java.nio.ByteBuffer;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-15
 */
public class KryoInput {

    private Input input;
    private Kryo kryo;

    public KryoInput(ByteBuffer buf){
        input = new Input(buf.array());
        kryo = RickKryoUtils.borrow();
    }

    public <T> T readObject(Class<T> clazz){
        return kryo.readObjectOrNull(input,clazz);
    }

    public void clean(){
        RickKryoUtils.release(kryo);
        kryo = null;
    }

}
