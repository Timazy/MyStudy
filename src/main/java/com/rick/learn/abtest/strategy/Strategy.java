package com.rick.learn.abtest.strategy;
/*
*	@author : Rick
*	@date : 2019年4月29日
*	
*/
public enum Strategy {
	
	HASH("hash"),TAG("tag");
	
	String name;
	
	Strategy(String name){
		this.name = name;
	}
	
	
	
	
	public static void main(String[] args) {
		String a = "rick";
		long al = 123;
		
		for (int i = 0; i < 2; i++) {
			System.out.println(a.hashCode());
			System.out.println(((Object)al).hashCode());
		}
	}
	
}
