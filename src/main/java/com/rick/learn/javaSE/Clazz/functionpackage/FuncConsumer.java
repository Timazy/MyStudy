package com.rick.learn.javaSE.Clazz.functionpackage;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-01-16
 */
public class FuncConsumer {

    public static void main(String[] args) {
        List<Fuc> is = new LinkedList<>();
        is.add(new FuncConsumer.Fuc(1));
        is.add(new FuncConsumer.Fuc(2));
        is.add(new FuncConsumer.Fuc(3));
    }



    static class Fuc{
        private int i;

        Fuc(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    static class FucConsumer implements Consumer<Fuc> {

        @Override
        public void accept(Fuc fuc) {
            System.out.println(fuc.getI());
        }

        @Override
        public Consumer<Fuc> andThen(Consumer<? super Fuc> after) {
            return null;
        }
    }


}
