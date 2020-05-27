package com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.io;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.RickKryoUtils;

import java.nio.ByteBuffer;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-10
 */
public class KryoOutput {

    private Output output;
    private Kryo kryo;


    public KryoOutput(ByteBuffer buf){
        output = new Output(buf.array());
        kryo = RickKryoUtils.borrow();
    }


    public void writeObject(Object o){
        kryo.writeClassAndObject(output,o);
    }

    public int position(){
        return output.position();
    }

    public void clean(){
        RickKryoUtils.release(kryo);
        kryo = null;
    }


}
