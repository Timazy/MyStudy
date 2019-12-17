package com.rick.learn.fullfill.aqs.locker;

import java.util.concurrent.TimeUnit;

/*
*	@author : Rick
*	@date : 2019年4月18日
*	
*/
public interface Lock {

	void lock();
	
	void lockInterruptibly();
	
	boolean tryLock();
	
	void await();
	
	void await(long nanos);
	
	boolean tryLock(long timeMillis,TimeUnit timeUnit);
	
	void unLock();
	
}
