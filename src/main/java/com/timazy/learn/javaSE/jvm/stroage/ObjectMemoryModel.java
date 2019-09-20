package com.timazy.learn.javaSE.jvm.stroage;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/*
*	@author : Rick
*	@date : May 22, 2019
*	
*/
public class ObjectMemoryModel {

	public static void main(String[] args) throws Exception {
        System.out.println(VM.current().details());

        final A a = new A();
        final B b = new B();

        System.out.println("A:"+ClassLayout.parseInstance(a).toPrintable());
        System.out.println("B"+ClassLayout.parseInstance(b).toPrintable());
        
    }

    public static class A {
    	volatile long q0, q1, q2, q3, q4, q5, q6;
    	public volatile long value = 0L;
    }
    
    public static class B{
    	 volatile long p0, p1, p2, p3, p4, p5, p6;  
         public volatile long value = 0L;  
         volatile long q0, q1, q2, q3, q4, q5, q6;  
    }
    
}
