package com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer.factory;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.DefaultSerializers;
import com.rick.learn.javaSE.jvm.offheap.entity.MyObJ;
import com.rick.learn.javaSE.jvm.offheap.entity.SubOBJ;

import java.util.*;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-09
 */
public abstract class AbstractKryoFactory {

    //simplify
    public Kryo create(){
        Kryo kryo = new Kryo();
        //不允许同类饮用
        kryo.setReferences(true);
        //所有的类都必须预先注册
        kryo.setRegistrationRequired(true);
        kryo.register(ArrayList.class,new DefaultSerializers.ArraysAsListSerializer());
        kryo.register(LinkedList.class,new DefaultSerializers.ArraysAsListSerializer());
        kryo.register(Arrays.asList().getClass());
        kryo.register(List.class);
        //kryo.register(SubOBJ.class);
        kryo.register(MyObJ.class);
        return kryo;
    }

    public abstract void returnKryo(Kryo kryo);

    public abstract Kryo borrowKryo();

    public static void main(String[] args) {
        System.out.println(Collections.EMPTY_LIST.getClass());
        System.out.println(Collections.singletonList(null).getClass());
        System.out.println(Arrays.asList().getClass());
        Class clazz = List.class;
        System.out.println(clazz);
        System.out.println(ArrayList.class);
    }

}
