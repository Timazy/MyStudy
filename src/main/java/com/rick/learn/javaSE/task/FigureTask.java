package com.rick.learn.javaSE.task;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-01-09
 */
public class FigureTask extends Thread{

    private int priority;
    private BufferedWriter writer;
    private String figure;
    private CountDownLatch latch;
    private CyclicBarrier barrier;

    FigureTask(int priority, BufferedWriter bufferedWriter, String figure, CyclicBarrier barrier){
        this.priority = priority;
        this.writer = bufferedWriter;
        this.figure = figure;
        this.barrier = barrier;
    }

    public void reset(int priority, BufferedWriter bufferedWriter){
        this.priority = priority;
        this.writer = bufferedWriter;
    }

    @Override
    public void run() {
        while (ATask.loop > 0){
            synchronized (ATask.LOCK) {

                if (ATask.turn != priority){
                    try {
                        ATask.LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        writer.write(figure);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    ATask.turn++;
                    if (ATask.turn > 3){
                        ATask.turn = 1;
                        ATask.loop--;
                    }

                    ATask.LOCK.notifyAll();
                }
            }
        }

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

}
