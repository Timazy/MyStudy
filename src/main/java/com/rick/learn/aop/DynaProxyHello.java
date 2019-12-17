package com.rick.learn.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxyHello implements InvocationHandler {

	//
	private Object proxy;
	
	
	private Object delegate;
	
	public Object bind(Object delegate,Object proxy){
		
		this.proxy = proxy;
		this.delegate = delegate;
		
		
		//这里是怎么装配进去的？？？？？
		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(),this.delegate.getClass().getInterfaces() , this);

	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object result = null;
		
		try{
			
			Class clazz = this.proxy.getClass();
			Method start = clazz.getDeclaredMethod("start", new Class[]{Method.class});
			
			start.invoke(this.proxy, new Object[]{method});
			
			result = method.invoke(this.delegate, args);
			
			Method end = clazz.getDeclaredMethod("end",new Class[]{Method.class});
			
			end.invoke(this.proxy, new Object[]{method});
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
