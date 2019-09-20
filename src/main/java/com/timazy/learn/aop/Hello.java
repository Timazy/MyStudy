package com.timazy.learn.aop;

public class Hello implements SayHello {

	public void sayHello(String name) {

		System.out.println("Hello" + name);
	}

	public void sayGoodBye(String name) {
		
		System.out.println("GoodBye" + name);
	}

	public class a {
		public int a=1;
	}
}
