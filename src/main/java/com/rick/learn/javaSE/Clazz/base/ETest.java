package com.rick.learn.javaSE.Clazz.base;

import lombok.Data;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-15
 */
public class ETest {


    public static void main(String[] args) {
        E e1 = new E(10000,20000);
        E e2 = new E(10000,20000);
        System.out.println(e1.equals(e2));
        System.out.println(e1.hashCode() + "---" + e2.hashCode());
    }


    @Data
    static class E{
        private Integer a;
        private int b;

        public E(Integer a, int b) {
            this.a = a;
            this.b = b;
        }
    }


}
