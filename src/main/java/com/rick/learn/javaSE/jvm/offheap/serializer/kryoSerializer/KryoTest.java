package com.rick.learn.javaSE.jvm.offheap.serializer.kryoSerializer;

import com.alibaba.fastjson.JSON;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.rick.learn.javaSE.jvm.offheap.entity.MyObJ;
import com.rick.learn.javaSE.jvm.offheap.entity.SubOBJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-09
 */
public class KryoTest {

    public static void main(String[] args) throws FileNotFoundException {
        Kryo kryo = RickKryoUtils.borrow();
        MyObJ obj = new MyObJ(1);
        obj.setFigure(1234L);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        obj.setList(Arrays.asList(1,2,3));
        SubOBJ sub = new SubOBJ();
        sub.setV(2);
        obj.setSub(sub);


        byte[] b = new byte[1024];


        Output output = new Output(b);
        kryo.writeObject(output,obj);
        output.close();

        Input input = new Input(b);
        MyObJ my = kryo.readObject(input,MyObJ.class);
        input.close();

        System.out.println(JSON.toJSONString(my));
    }


}
