package com.rick.learn.javaSE.task;

import java.util.concurrent.CountDownLatch;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-01-09
 */
public class MyTask {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);
        FileHandler handler = new FileHandler();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //for (int i=0;i<10;i++){
                while (!handler.endLoop()){
                    handler.print1();
                }
                //handler.a();
                latch.countDown();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //for (int i=0;i<10;i++){
                while (!handler.endLoop()){
                    handler.print2();
                }
                //handler.a();
                latch.countDown();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                //for (int i=0;i<10;i++){
                while (!handler.endLoop()){
                    handler.print3();
                }
                //handler.a();
                latch.countDown();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        handler.destroy();
    }
}
