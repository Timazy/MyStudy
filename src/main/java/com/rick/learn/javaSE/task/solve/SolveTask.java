package com.rick.learn.javaSE.task.solve;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * question:设计三个线程，一个线程只能输出1 一个线程只能输出2 一个线程只能输出3 。
 * 要求：输出三个文件，内容分别是 123123123123.... 321321321... 312312312... 每个文件输出各自规范的数字 10 组
 * @Date 2020-01-10
 */
public class SolveTask {

    public static void main(String[] args) throws IOException {
        BufferedWriter writer1 = openBufferedWriter("123.txt");
        BufferedWriter writer2 = openBufferedWriter("321.txt");
        BufferedWriter writer3 = openBufferedWriter("312.txt");

        FileCtx f1 = new FileCtx(writer1,10,new LinkedList<>(Arrays.asList(1,2,3)),1);
        FileCtx f2 = new FileCtx(writer2,10,new LinkedList<>(Arrays.asList(3,2,1)),2);
        FileCtx f3 = new FileCtx(writer3,10,new LinkedList<>(Arrays.asList(3,1,2)),3);

        ExecutorService executorService = new ThreadPoolExecutor(3, 3, 0,
                TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(),
                new ThreadFactoryBuilder().setNameFormat("线程(%d)").build());

        executorService.submit(new Task(1,f1,f2,f3));
        executorService.submit(new Task(2,f1,f2,f3));
        executorService.submit(new Task(3,f1,f2,f3));

        while (!(f1.endLoop() && f2.endLoop() && f3.endLoop())) {

        }
        writer1.close();
        writer2.close();
        writer3.close();
        System.out.println("结束了");
        executorService.shutdown();
    }

    static class FileCtx {

        private BufferedWriter writer;
        private ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        private LinkedList<Integer> slidingWindow;
        private volatile int loop;
        private int cate;

        FileCtx(BufferedWriter writer,int loop,LinkedList<Integer> slide,int cate){
            this.writer = writer;
            this.loop = loop * slide.size();
            this.slidingWindow = slide;
            this.cate = cate;
            queue.offer(slide.get(0));
            queue.offer(slide.get(1));
            queue.offer(slide.get(2));
        }

        public boolean writeLoop(int figure){
            if (loop > 0){
                Integer f = slidingWindow.getFirst();
                //Integer f = queue.peek();
                if (f == null){
                    System.out.println("nulllll");
                }
                if (f == figure){
                    //System.out.println(Thread.currentThread().getName() + "--"+cate + " figure:"+figure);
                    if (loop == 0){
                        return true;
                    }
                    try {
                        writer.write(String.valueOf(figure));
                        loop--;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    slide();
                }
                return false;
            }else {
                return true;
            }
        }

        private synchronized void slide(){
            //System.out.println(Thread.currentThread().getName() + "--" + cate +"--" + slidingWindow.get(0) + " "+slidingWindow.get(1) + " "+ slidingWindow.get(2));
            slidingWindow.addLast(slidingWindow.removeFirst());
            //queue.offer(queue.poll());
        }

        public boolean endLoop(){
            return this.loop == 0;
        }

    }

    static class Task implements Runnable{

        private int figure;
        private LinkedList<FileCtx> fileCtxs = new LinkedList<>();

        Task(int figure, FileCtx f1, FileCtx f2, FileCtx f3){
            this.figure = figure;
            fileCtxs.addLast(f1);
            fileCtxs.addLast(f2);
            fileCtxs.addLast(f3);
        }

        @Override
        public void run() {
            while (!fileCtxs.isEmpty()){
                Iterator<FileCtx> iterator = fileCtxs.iterator();
                while (iterator.hasNext()){
                    boolean end = iterator.next().writeLoop(figure);
                    if (end){
                        System.out.println("--remove--");
                        iterator.remove();
                    }
                }
            }
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
