package com.rick.learn.javaSE.aqs;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
*	@author : timazy
*	@date : 2019年3月10日
*	
*/
public class Exchange_s {

	public static void main(String[] args) {
	 
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Exchanger<Integer> exchanger = new Exchanger<>();
		
		Thread task1 = new Thread(new Runnable(){
		
			@Override
			public void run() {
				try {
					Integer from2 = exchanger.exchange(1, 2000, TimeUnit.MILLISECONDS);
					System.out.println("Task1 deal with :"+from2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (TimeoutException e) {
					e.printStackTrace();
				}
			}
		});
	
		Thread task2 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					Integer from1 = exchanger.exchange(2);
					System.out.println("Task2 deal with :"+from1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		executor.execute(task1);
		executor.execute(task2);
		
		executor.shutdown();
		
		
	}

}
