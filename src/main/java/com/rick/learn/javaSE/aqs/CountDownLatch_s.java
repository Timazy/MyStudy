package com.rick.learn.javaSE.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
*	@author : timazy
*	@date : 2019年2月16日
*	
*/
public class CountDownLatch_s {

	public static void main(String[] args) {
	 
		CountDownLatch latch = new CountDownLatch(2);
		Thread task1 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					System.out.println(Thread.currentThread().getName() + " run");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				latch.countDown();
			}
		});
		Thread task2 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					System.out.println(Thread.currentThread().getName() + " run");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				latch.countDown();
			}
		});
		
		task1.start();
		task2.start();
		try {
			latch.await(3000,TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}


}
