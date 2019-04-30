package com.timazy.learn.abtest.strategy;
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
	
	
	
}
