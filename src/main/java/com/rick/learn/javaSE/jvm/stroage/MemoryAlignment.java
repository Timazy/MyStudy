package com.rick.learn.javaSE.jvm.stroage;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/*
*	@author : Rick
*	@date : May 22, 2019
*	
*/
public class MemoryAlignment {

	public static void main(String[] args) throws Exception {
        System.out.println(VM.current().details());

        final A a = new A();

        final D d = new D();
        System.out.println("A:"+ClassLayout.parseInstance(a).toPrintable());
        System.out.println("D:"+ClassLayout.parseInstance(d).toPrintable());
    }
	
//concern the order
    public static class A {
        boolean bo1, bo2;
        byte b1, b2;
        char c1, c2;
        double d1, d2;
        float f1, f2;
        int i1, i2;
        long l1, l2;
        short s1, s2;
    }
    
    public static class B{
    	int b;
    }
    
    public static class C extends B{
    	int  c;
    }
    
    public static class D extends C{
    	int  d;
    }
    
    
    
}
