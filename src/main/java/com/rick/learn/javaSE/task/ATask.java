package com.rick.learn.javaSE.task;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-01-09
 */
public class ATask {

    public static final Object LOCK = new Object();

    public static int turn = 1;

    public static int loop = 10;

    public static void main(String[] args) {

        try {
            //CountDownLatch latch = new CountDownLatch(3);
            //Semaphore semaphore = new Semaphore(3);
            CyclicBarrier barrier = new CyclicBarrier(4);

            BufferedWriter writer1 = openBufferedWriter("123.txt");

            FigureTask figure1Thread = new FigureTask(1,writer1,"1",barrier);
            FigureTask figure2Thread = new FigureTask(2,writer1,"2",barrier);
            FigureTask figure3Thread = new FigureTask(3,writer1,"3",barrier);
            figure1Thread.start();
            figure2Thread.start();
            figure3Thread.start();

            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            writer1.close();
            barrier.reset();
            reset();

            BufferedWriter writer2 = openBufferedWriter("321.txt");
            figure1Thread.reset(3,writer2);
            figure1Thread.start();
            figure2Thread.reset(2,writer2);
            figure1Thread.start();
            figure3Thread.reset(1,writer2);
            figure1Thread.start();

            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            writer2.close();
            barrier.reset();
            reset();


            BufferedWriter writer3 = openBufferedWriter("312.txt");
            figure1Thread.reset(2,writer3);
            figure1Thread.start();
            figure2Thread.reset(3,writer3);
            figure1Thread.start();
            figure3Thread.reset(1,writer3);
            figure1Thread.start();

            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            writer3.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static BufferedWriter openBufferedWriter(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.createNewFile()){
            System.out.println("file : "+fileName+" created");
        }else {
            System.out.println("file : "+fileName+" exists");
        }
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8),1024);
        //return new BufferedWriter(new FileWriter(file,true),1024);
    }

    public static void reset(){
        ATask.turn = 1;
        ATask.loop = 10;
    }




}
