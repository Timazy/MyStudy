package com.rick.learn.javaSE.aqs.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-11
 */
public class TwinsLock implements Lock {

    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count){
            if (count < 0){
                throw new IllegalArgumentException("count must large than zero");
            }
            setState(count);
        }

        /**
         * 返回<0获取锁失败，进队列，>=0成功
         * @param reduceCount
         * @return
         */
        @Override
        public int tryAcquireShared(int reduceCount){
            for (;;){
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount < 0){
                    return newCount;
                }else {
                    //>=0 可以去竞争一下
                    if (compareAndSetState(current,newCount)){
                        return newCount;
                    }
                }

                /* or in this way
                if (newCount < 0 || compareAndSetState(current,newCount)){
                    return newCount;
                }*/
            }
        }


        @Override
        public boolean tryReleaseShared(int returnCount){
            for (;;){
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }


        public boolean tryAcquireSharedReturnImmediately(int reduceCount){
            int current = getState();
            int newCount = current - reduceCount;
            if (newCount < 0){
                return false;
            }else {
                //>=0 可以去竞争一下
                if (compareAndSetState(current,newCount)){
                    System.out.println(Thread.currentThread().getName() + "-current-" + current);
                    return true;
                }else {
                    return false;
                }
            }

            /* or in this way
            if (newCount < 0 || !compareAndSetState(current,newCount)){
                return false;
            }
            return true;*/
        }
    }



    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquireSharedReturnImmediately(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return newCondition();
    }


    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new TwinsLock();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(() -> {
                while (true){

                    //lock.lock();
                    try {
                        if (lock.tryLock()){
                            System.out.println(Thread.currentThread().getName());
                            lock.unlock();
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //System.out.println(Thread.currentThread().getName());


                    } finally {
                        //lock.unlock();
                    }
                }
            });
            threads[i] = thread;
        }
        for (int i=9;i>=0;i--){
            threads[i].setDaemon(true);
            threads[i].start();
        }

        for (int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }


    }




}
