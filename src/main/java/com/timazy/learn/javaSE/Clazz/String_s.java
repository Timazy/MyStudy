package com.timazy.learn.javaSE.Clazz;

import static org.hamcrest.CoreMatchers.nullValue;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/*
*	@author : timazy
*	@date : 2019年3月3日
*	
*/
public class String_s {

	public static <V> void main(String[] args) {
		StringBuffer buffer = new StringBuffer("java");
		StringBuilder builder = new StringBuilder("java");
		builder.append("");
		buffer.append("");
		Set<String> set = new HashSet<>();
		Runtime.getRuntime();
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("a", "2");
		
		Future<Object> future = new FutureTask<>(new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				 
				return null;
			}
		});
	}
	
	
}
