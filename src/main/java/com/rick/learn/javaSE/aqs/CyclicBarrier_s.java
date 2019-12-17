package com.rick.learn.javaSE.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
*	@author : timazy
*	@date : 2019年2月16日
*	
*/
public class CyclicBarrier_s {

	public static void main(String[] args) {
	 
		CyclicBarrier barrier = new CyclicBarrier(2, new prior());
		
		new Thread(new Runnable(){
		
			@Override
			public void run() {
				 System.out.println(Thread.currentThread().getName() + " access barrier");
				try {
					barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		try {
			System.out.println(Thread.currentThread().getName() + " access barrier");
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	
		//reuse
		barrier.reset();
		
	}

	
	static class prior implements Runnable{

		@Override
		public void run() {

			System.out.println("two thread accessed barrier,prior thread start");
			
		}
		
	}
	
}
