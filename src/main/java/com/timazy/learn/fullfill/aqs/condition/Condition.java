package com.timazy.learn.fullfill.aqs.condition;
/*
*	@author : Rick
*	@date : 2019年4月19日
*	
*/
public interface Condition {

	void await();
	
	void signalAll();
	
}
