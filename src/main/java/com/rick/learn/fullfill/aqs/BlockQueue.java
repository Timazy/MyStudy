package com.rick.learn.fullfill.aqs;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import com.rick.learn.fullfill.aqs.locker.Lock;
import com.rick.learn.fullfill.aqs.queue.Queue;

/*
*	@author : Rick
*	@date : 2019年4月18日
*	
*/
public class BlockQueue<E> {

	private Lock locker;
	private Queue<E> queue;
	
	public int count;
	
	public E poll(long timeMillis,TimeUnit unit){
		long nanos = unit.toNanos(timeMillis);
		locker.lock();
		try{
			while (count == 0) {
				if (nanos < 0) {
					return null;
				}
				locker.await(nanos);
			}
			return queue.deQueue();
		}finally {
			locker.unLock();
		}
	}
	
	public E poll(){
		locker.lock();
		try{
			if (count == 0) {
				return null;
			}
			return queue.deQueue();
		}finally {
			locker.unLock();
		}
	}
	
	public boolean offer(E e,long timeMillis,TimeUnit unit){
		checkNotNull(e);
		long nanos = unit.toNanos(timeMillis);
		locker.lock();
		try{
			while (count == queue.size()) {
				if (nanos < 0) {
					return false;
				}
				locker.await(nanos);
			}
			queue.enQueue(e);
		}finally {
			locker.unLock();
		}
		return true;
	}
	
	
	public boolean offer(E e){
		checkNotNull(e);
		locker.lock();
		try {
			if (count == queue.size()) {
				return false;
			}
			queue.enQueue(e);
			return true;
		} finally {
			locker.unLock();
		}
	}
	
	public int size(){
		locker.lock();
		try{
			return count;
		}finally {
			locker.unLock();
		}
	}
	
	
	private static void checkNotNull(Object e){
		if (e == null) {
			throw new NullPointerException();
		}
	}
	
	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> hashMap = new ConcurrentHashMap<>();
		System.out.print(hashMap.putIfAbsent("a", "bb"));
		System.out.print(hashMap.putIfAbsent("a", "a"));
		
		
	}
	
}
