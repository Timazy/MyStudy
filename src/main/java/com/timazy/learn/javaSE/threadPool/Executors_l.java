package com.timazy.learn.javaSE.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
*	@author : Rick
*	@date : May 6, 2019
*	
*/
public class Executors_l {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 3; i++) {
			executor.execute(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						Thread.sleep(300000);
						System.out.println("thread alive");
					} catch (InterruptedException e) {
						System.out.println("thread shutdown");
						e.printStackTrace();
					}
					
				}
			});
		}
		
		if (!executor.isShutdown()) {
			System.out.println("main thread shutdown");
			executor.shutdown();
			while(true) {
				if (executor.isTerminated()) {
					System.out.print("all over");
					break;
				}
			}
			
		}
	}
}
