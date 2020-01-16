package com.rick.learn.javaSE.task;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;


/**
 * question:设计三个线程，一个线程只能输出1 一个线程只能输出2 一个线程只能输出3 。
 * 要求：输出三个文件，内容分别是 123123123123.... 321321321... 312312312... 每个文件输出各自规范的数字 10 组
 * @author Rick 郭亮
 */

@SuppressWarnings("Duplicates")
public class BTasks {

    public static void main(String[] args) throws Exception {
        BufferedWriter writer1 = openBufferedWriter("123.txt");
        BufferedWriter writer2 = openBufferedWriter("321.txt");
        BufferedWriter writer3 = openBufferedWriter("312.txt");

        FileObj f1 = new FileObj(new LinkedList<>(Arrays.asList(1,2,3)), writer1);
        FileObj f2 = new FileObj(new LinkedList<>(Arrays.asList(3,2,1)), writer2);
        FileObj f3 = new FileObj(new LinkedList<>(Arrays.asList(3,1,2)), writer3);

        ExecutorService executorService = new ThreadPoolExecutor(3, 3, 0,
                TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(),
                new ThreadFactoryBuilder().setNameFormat("task-pool-%d").build());

        executorService.submit(new Job(f1, f2, f3, 1));
        executorService.submit(new Job(f1, f2, f3, 2));
        executorService.submit(new Job(f1, f2, f3, 3));
        while (!(f1.isEnd() && f2.isEnd() && f3.isEnd())) {

        }
        writer1.close();
        writer2.close();
        writer3.close();
        System.out.println("结束了");
        executorService.shutdown();
    }


    static class Job implements Runnable {

        private final List<FileObj> fileObjs = new ArrayList<>(3);
        private final int writeInt;

        public Job(FileObj f1, FileObj f2, FileObj f3, int writeInt) {
            fileObjs.add(f1);
            fileObjs.add(f2);
            fileObjs.add(f3);
            this.writeInt = writeInt;
        }

        @Override
        public void run() {

            while (!fileObjs.isEmpty()) {
                try {
                    Iterator<FileObj> iterator = fileObjs.iterator();
                    while (iterator.hasNext()) {
                        if (iterator.next().write(writeInt)){
                            iterator.remove();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class FileObj {
        private BufferedWriter bufferedWriter;
        private final ReentrantLock lock = new ReentrantLock();
        private int times = 30;

        final LinkedList<Integer> order;

        public FileObj(LinkedList<Integer> order, BufferedWriter writer) {
            this.order = order;
            this.bufferedWriter = writer;
        }

        public boolean write(int i) throws IOException {
            if (lock.tryLock()) {
                try {
                    if (times > 0) {
                        if (order.get(0).equals(i)) {
                            bufferedWriter.write(String.valueOf(i));
                            times--;
                            order.removeFirst();
                            order.addLast(i);
                        }
                    } else {
                        return true;
                    }
                } finally {
                    lock.unlock();
                }
            }
            return false;
        }

        public boolean isEnd() {
            return times <= 0;
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
    }
}