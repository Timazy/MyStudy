package com.rick.learn.javaSE.Clazz.threadLocal;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 *
 * Tip：为什么java.lang.ThreadLocal.ThreadLocalMap的Entry用弱索引
 * 1、有些代码需要正确的使用，优秀的代码都会对不正确使用作出必要的保护
 * 2、ThreadLocal 一般需要作为GCRoot，也就是static，保证整个jvm生命周期内都不会回收
 * 3、如果ThreadLocal被不正确使用（置null，方法栈结束），要保护jvm的稳定性
 * 4、如果Entry强引，reference永远指向ThreadLocal的地址，在代码编者眼里ThreadLocal已经不用了，但是仍然存在于线程的map中，和线程生命周期绑定，线程不结束，该ThreadLocal不释放，对应的
 * value也无法释放。
 * 5、如果使用了线程池，尤其是fix的，map就会一直堆积直到oom
 * 6、如果Entry弱引用ThreadLocal，ThreadLocal置null或方法栈结束，Entry中的reference没有任何一个GCRoot连接到它，gc就会回收掉，此Entry变为reference为null，value有值
 * 7、可以根据reference是否为null判定该entry是否可用，也就是为什么每次Threadlocal.get/set会剔除掉reference为null的entry
 *
 *
 * @Date 2019-12-16
 */
public class Test {
    public static void main(String[] args) {

        Thread main = Thread.currentThread();
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("a");
        Thread t = Thread.currentThread();
        threadLocal = null;
        System.gc();

        System.out.println(threadLocal.get());


        //log change
    }
}
