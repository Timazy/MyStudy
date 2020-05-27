package com.rick.learn.javaSE.jvm.offheap.serializer;

import com.rick.learn.javaSE.jvm.offheap.entity.MyObJ;
import com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.RickKryoUtils;
import com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.io.KryoInput;
import com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.io.KryoOutput;
import org.caffinitas.ohc.CacheSerializer;

import java.nio.ByteBuffer;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-01
 */
public class MyKeySerializer implements CacheSerializer<MyObJ> {

    @Override
    public void serialize(MyObJ value, ByteBuffer buf) {
        KryoOutput output = new KryoOutput(buf);
        output.writeObject(value);
    }

    @Override
    public MyObJ deserialize(ByteBuffer buf) {
        KryoInput input = new KryoInput(buf);
        return input.readObject(MyObJ.class);
    }

    @Override
    public int serializedSize(MyObJ value) {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        KryoOutput output = new KryoOutput(buf);
        output.writeObject(value);
        return output.position();
    }

    public static void main(String[] args) {

    }


}
