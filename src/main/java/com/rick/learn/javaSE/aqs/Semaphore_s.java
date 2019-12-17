package com.rick.learn.javaSE.aqs;

import java.util.concurrent.Semaphore;

/*
*	@author : timazy
*	@date : 2019年2月16日
*	
*/
public class Semaphore_s {

	public static void main(String[] args) {
	 
		Semaphore semaphore = new Semaphore(2, true);
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+" acquired");
					Thread.sleep(5000);
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+" acquired");
					Thread.sleep(5000);
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+" acquired");
					Thread.sleep(5000);
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
