package com.rick.learn.pattern.creational.singleton;

import java.io.*;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-14
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        System.out.println(hungrySingleton.toString());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial"));
        oos.writeObject(hungrySingleton);
        File file = new File("serial");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        HungrySingleton serializableSingleton = (HungrySingleton) ois.readObject();
        System.out.println(serializableSingleton.toString());
    }
}
