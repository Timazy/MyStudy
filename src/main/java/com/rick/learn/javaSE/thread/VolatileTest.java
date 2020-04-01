package com.rick.learn.javaSE.thread;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-10
 */
public class VolatileTest {

    public static volatile int i =1;


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int circle = 0;
                while (circle < 20000){
                    i ++;
                    circle++;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int circle = 0;
                while (circle < 20000){
                    i ++;
                    circle++;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
