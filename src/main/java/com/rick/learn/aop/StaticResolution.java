package com.rick.learn.aop;

/* problem
 * 1.Proxy.newProxyInstance 返回方法中con.getConstruct(Object[]{ProxyHandler}) 为什么会返回实例
 * 2.配置工程日志
 * 3.门面设计模式
 */
public class  StaticResolution{

	//public final static SayHello HELLO = new Meet();
	

	
	public static void main(String[] args) {
		SayHello hello = (SayHello) new DynaProxyHello().bind(new Hello(), new LoggerOperation());
		
		hello.sayHello("*hello*");
		hello.sayGoodBye("*goodbye*");
		/*try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*SayHello hello = new Meet();
		hello.sayHello("aaa");*/
	}
}
