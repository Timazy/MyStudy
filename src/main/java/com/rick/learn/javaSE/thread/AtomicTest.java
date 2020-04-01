package com.rick.learn.javaSE.thread;

import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-10
 */
public class AtomicTest {

    public static void main(String[] args) {

        Bundle pre = new Bundle();
        pre.setI(10);
        Bundle next = new Bundle();
        next.setI(1);
        AtomicReference<Bundle> atomic = new AtomicReference<>();
        atomic.set(pre);
        atomic.getAndAccumulate(next, (p , n) -> {
            p.setI(n.getI() + p.getI());
            return p;
        });
        System.out.println(atomic.get());

    }

    @Data
    public static class Bundle{
        public int i;
        public Bundle(){
            i=1;
        }
    }
}
