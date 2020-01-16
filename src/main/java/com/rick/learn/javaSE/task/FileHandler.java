package com.rick.learn.javaSE.task;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-01-09
 */
public class FileHandler {

    public BufferedWriter writer1;
    public BufferedWriter writer2;
    public BufferedWriter writer3;

    //public It it1;
    //public It it2;
    //public It it3;
    public ItWrapper itWrapper1;
    public ItWrapper itWrapper2;
    public ItWrapper itWrapper3;

    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public Condition condition1 = lock.newCondition();
    public Condition condition2 = lock.newCondition();
    public Condition condition3 = lock.newCondition();


    public FileHandler(){
        try {
            writer1 = openBufferedWriter("123.txt");
            writer2 = openBufferedWriter("321.txt");
            writer3 = openBufferedWriter("312.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        It it1 = new It(1);
        it1.setNext(2).setNext(3).setNext(it1);
        itWrapper1 = new ItWrapper(it1);

        It it2 = new It(3);
        it2.setNext(2).setNext(1).setNext(it2);
        itWrapper2 = new ItWrapper(it2);

        It it3 = new It(3);
        it3.setNext(1).setNext(2).setNext(it3);
        itWrapper3 = new ItWrapper(it3);
    }

    public void destroy(){
        try {
            writer1.close();
            writer2.close();
            writer3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean writable(int order){
        return itWrapper1.getTurn() == order || itWrapper2.getTurn() == order || itWrapper3.getTurn() == order;
    }

    public void a(){
        lock.lock();
        wakeUp();
        lock.unlock();
    }

    public void wakeUp(){
        condition1.signalAll();
        condition2.signalAll();
        condition3.signalAll();
       /* switch (it.getTurn()){
            case 1:
                condition1.signal();
                break;
            case 2:
                condition2.signal();
                break;
            case 3:
                condition3.signal();
                break;
        }*/
    }

    public void print1(){
        lock.lock();

        while (!writable(1)){
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //writable
        if (itWrapper1.getTurn() == 1){
            //write
            try {
                System.out.println("write1 print 1");
                writer1.write("1");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //it1 = it1.next;
            if (itWrapper1.next() != null){
                wakeUp();
            }

        }

        if (itWrapper2.getTurn() == 1){
            //write
            try {
                System.out.println("write2 print 1");
                writer2.write("1");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //it2 = it2.next;
            if (itWrapper2.next() != null){
                wakeUp();
            }
        }

        if (itWrapper3.getTurn() == 1){
            //write
            try {
                System.out.println("write3 print 1");
                writer3.write("1");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //it3 = it3.next;
            if (itWrapper3.next() != null){
                wakeUp();
            }
        }

        lock.unlock();


    }


    public void print2(){
        lock.lock();

        while (!writable(2)){
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //writable
        if (itWrapper1.getTurn() == 2){
            //write
            try {
                System.out.println("write1 print 2");
                writer1.write("2");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //it1 = it1.next;
            if (itWrapper1.next() != null){
                wakeUp();
            }
        }

        if (itWrapper2.getTurn() == 2){
            //write
            try {
                System.out.println("write2 print 2");
                writer2.write("2");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //it2 = it2.next;
            if (itWrapper2.next() != null){
                wakeUp();
            }
        }

        if (itWrapper3.getTurn() == 2){
            //write
            try {
                System.out.println("write3 print 2");
                writer3.write("2");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //it3 = it3.next;
            if (itWrapper3.next() != null){
                wakeUp();
            }
        }

        lock.unlock();


    }

    public void print3(){
        lock.lock();

        while (!writable(3)){
            try {
                condition3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //writable
        if (itWrapper1.getTurn() == 3){
            //write
            try {
                System.out.println("write1 print 3");
                writer1.write("3");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //it1 = it1.next;
            if (itWrapper1.next() != null){
                wakeUp();
            }
        }

        if (itWrapper2.getTurn() == 3){
            //write
            try {
                System.out.println("write2 print 3");
                writer2.write("3");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //it2 = it2.next;
            if (itWrapper2.next() != null){
                wakeUp();
            }
        }

        if (itWrapper3.getTurn() == 3){
            //write
            try {
                System.out.println("write3 print 3");
                writer3.write("3");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //it3 = it3.next;
            if (itWrapper3.next() != null){
                wakeUp();
            }
        }

        lock.unlock();


    }




    public BufferedWriter openBufferedWriter(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.createNewFile()){
            System.out.println("file : "+fileName+" created");
        }else {
            System.out.println("file : "+fileName+" exists");
        }
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8),1024);
    }

     class It{
        public It next;
        public int turn;

        It(int init){
            this.turn = init;
        }

        public It setNext(int turn){
            this.next = new It(turn);
            return next;
        }

        public void setNext(It it){
            this.next = it;
        }

        public int getTurn() {
            return turn;
        }

        public void setTurn(int turn) {
            this.turn = turn;
        }


    }
    class ItWrapper{

        public It it;
        public int round = 3;

        public It next(){
            round --;
//            if (round < 0){
//                return null;
//            }
            it = it.next;
            return it;
        }

        public int getTurn(){
            if (round <= 0){
                return 0;
            }
            return it.turn;
        }


        ItWrapper(It it){
            this.it = it;
        }

        public boolean end(){
            return round <= 0;
        }

    }

    public boolean endLoop(){
        return itWrapper1.end() && itWrapper2.end() && itWrapper3.end();
    }

}
