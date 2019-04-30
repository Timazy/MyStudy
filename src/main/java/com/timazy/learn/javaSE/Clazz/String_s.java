package com.timazy.learn.javaSE.Clazz;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import sun.misc.Unsafe;

/*
*	@author : timazy
*	@date : 2019年3月3日
*	r
*/
public class String_s {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer("java");
		StringBuilder builder = new StringBuilder("java");
		Set<String> set = new HashSet<>();
		Runtime.getRuntime();
		
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		
		Future<Object> future = new FutureTask<>(new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				 
				return null;
			}
		});
		
		
		Unsafe unsafe = getUnsafe();
		org.springframework.util.Assert.notNull(unsafe);
	}
	
	
	private static Unsafe getUnsafe(){
	    try {
	        Field field = Unsafe.class.getDeclaredField("theUnsafe");
	        field.setAccessible(true);
	        Unsafe unsafe = (Unsafe) field.get(null);
	        return unsafe;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
}
