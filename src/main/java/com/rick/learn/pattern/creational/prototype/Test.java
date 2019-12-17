package com.rick.learn.pattern.creational.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tianxiaobao@gegejia.com
 * @Description 原型模式 克隆 深浅
 * @Date 2019-12-14
 */
@SuppressWarnings("Duplicates")
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Date> list = new ArrayList<>();
        list.add(new Date());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial"));
        oos.writeObject(list);
        File file = new File("serial");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ArrayList sList = (ArrayList) ois.readObject();
        System.out.println(sList.get(0));
    }


}
