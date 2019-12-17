package com.rick.learn.javaSE.jvm.memory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
*	@author : Rick
*	@date : Jun 10, 2019
*	refer to : https://www.oreilly.com/library/view/java-performance-tuning/0596000154/ch10s06.html
*  thread safe except long、double
*/
public class AtomicAssignment {

	private BaseOb ob;
	
	public void setBase1() {
		ob = new BaseOb();
	}
	public void setBase2() {
		ob = new BaseOb();
	}
	
	public void check() {
		if (ob == null) {
			System.out.print("error");
		}
		
	}

	public static void main(String[] args) {
		
		final AtomicAssignment ob = new AtomicAssignment();
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.submit(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					ob.setBase1();
				}
			}
		});
		service.submit(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					ob.setBase2();
				}
			}
		});
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	service.submit(new Runnable() {
	
		@Override
		public void run() {
			while(true) {
				ob.check();
			}

		}
	});
	}
	

	
}

