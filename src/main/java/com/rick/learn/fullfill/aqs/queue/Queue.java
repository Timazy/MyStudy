package com.rick.learn.fullfill.aqs.queue;
/*
*	@author : Rick
*	@date : 2019年4月18日
*	
*/
public interface Queue<T> {

	T deQueue();
	
	void enQueue(T entity);
	
	int size();
	
	
	
}
