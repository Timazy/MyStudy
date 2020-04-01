package com.rick.learn.javaSE.aqs.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-11
 */
public class BoundedQueue<T> {
    private Object[] items;
    private int addIndex,removeIndex,count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size){
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length){
                notFull.await();
            }
            items[addIndex] = t;
            System.out.println(Thread.currentThread().getName() + " added " +t);
            if (++addIndex == items.length){
                addIndex = 0;
            }
            count++;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                notEmpty.await();
            }
            Object t = items[removeIndex];
            System.out.println(Thread.currentThread().getName() + " removed " +t);
            if (++removeIndex == items.length){
                removeIndex = 0;
            }
            count--;
            notFull.signal();
            return (T)t;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedQueue<Integer> queue = new BoundedQueue<>(10);
        Thread addT = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    try {
                        queue.add(i);
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        addT.start();

        Thread.sleep(100);

        Thread removeT = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    try {
                        queue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        removeT.start();

        addT.join();
        removeT.join();
    }


}
