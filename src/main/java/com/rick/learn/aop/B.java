package com.rick.learn.aop;

public class B {

	
	public static void main(String[] args) {
		
		SayHello hello = new CglibProxyFactory<SayHello>().bind(new Hello(), new LoggerOperation());
		hello.sayHello("dududu");
		hello.sayGoodBye("lalala");
	}
}
