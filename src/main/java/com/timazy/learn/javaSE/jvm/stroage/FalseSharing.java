package com.timazy.learn.javaSE.jvm.stroage;
/*
*	@author : Rick
*	@date : May 22, 2019
*	
*/
public class FalseSharing implements Runnable{


    public final static int NUM_THREADS = 4; // change  
    public final static long ITERATIONS = 500L * 1000L * 1000L;  
    private final int arrayIndex;  
  
    private static VolatileLong5[] longs = new VolatileLong5[NUM_THREADS];  
    static {  
        for (int i = 0; i < longs.length; i++) {  
            longs[i] = new VolatileLong5();  
        }  
    }  
  
    public FalseSharing(final int arrayIndex) {  
        this.arrayIndex = arrayIndex;  
    }  
  
    public static void main(final String[] args) throws Exception {  
        long start = System.nanoTime();  
        runTest();  
        System.out.println("duration = " + (System.nanoTime() - start));  
    }  
  
    private static void runTest() throws InterruptedException {  
        Thread[] threads = new Thread[NUM_THREADS];  
  
        for (int i = 0; i < threads.length; i++) {  
            threads[i] = new Thread(new FalseSharing(i));  
        }  
  
        for (Thread t : threads) {  
            t.start();  
        }  
  
        for (Thread t : threads) {  
            t.join();  
        }  
    }  
  
    @Override
    public void run() {  
        long i = ITERATIONS + 1;  
        while (0 != --i) {  
            longs[arrayIndex].value = i;  
        }  
    }  
  
    public final static class VolatileLong {  
        public volatile long value = 0L;  
    }  
  
    // long padding避免false sharing  
    // 按理说jdk7以后long padding应该被优化掉了，但是从测试结果看padding仍然起作用  
    public final static class VolatileLong2 {  
        volatile long p0, p1, p2, p3, p4, p5, p6;  
        public volatile long value = 0L;  
        volatile long q0, q1, q2, q3, q4, q5, q6;  
    }  
  
    // jdk8新特性，Contended注解避免false sharing  
    // Restricted on user classpath  
    // Unlock: -XX:-RestrictContended  
    @sun.misc.Contended  
    public final static class VolatileLong3 {  
        public volatile long value = 0L;  
    }  
    
    public final static class VolatileLong4{
    	volatile long q0, q1, q2, q3, q4, q5, q6;
    	public volatile long value = 0L;
    }
    
    public final static class VolatileLong5{
    	public volatile long value = 0L;
    	volatile long q0, q1, q2, q3, q4, q5, q6;
    }
    
    public final static class VolatileLong6{
    	public volatile long value = 0L;
    	volatile long q0, q1, q2, q3, q4;
    }
    //thread=4
    //raw:duration = 37584155919
    //jdk7:duration = 4722822016
    //jdk8:duration = 4559271873
    //v4:   duration = 4402403797
    //v5:   duration = 4367633046
    //v6:   duration = 28082344187
    
    //thread=8
    //raw:duration = 39145721974
    //jdk7:duration = 7157514631
    //jdk8:duration = 7765687747
    //v4:   duration = 7596804997
    //v5:	  duration = 7637512273
    //v6:   duration = 29097564037
    		
}
