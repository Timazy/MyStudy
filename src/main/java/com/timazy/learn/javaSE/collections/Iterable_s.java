package com.timazy.learn.javaSE.collections;

import java.util.Iterator;

/*
*	@author : timazy
*	@date : 2019年2月13日
*	
*/
public class Iterable_s implements Iterable<String>{

	String[] elements = {"a","b","c","d"};
	int size = elements.length;
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			private int cursor = -1;
			@Override
			public boolean hasNext() {
				 return cursor + 1 < size;
			}

			@Override
			public String next() {
				cursor ++;
				 return elements[cursor];
				
			}
			
		};
		
	}

	public static void main(String[] args) {
		Iterable_s it = new Iterable_s();
		Iterator<String> iterator = it.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}
	
	
}
