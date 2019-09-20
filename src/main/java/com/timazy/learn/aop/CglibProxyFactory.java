package com.timazy.learn.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyFactory <T> implements MethodInterceptor{

	//aspect
	private Object proxy;
	
	private Object delegate;
	
	public <T> T bind(T delegate,Object proxy) {
		this.proxy = proxy;
		this.delegate = delegate;
		
		return (T) getInstance(this, delegate.getClass());
		
	}
	
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		Class clazz = this.proxy.getClass();
		Method start = clazz.getDeclaredMethod("start", new Class[] {Method.class});
		start.invoke(this.proxy, new Object[]{method});
		
		Object result = proxy.invokeSuper(obj, args);
		
		Method end = clazz.getDeclaredMethod("end", new Class[] {Method.class});
		end.invoke(this.proxy, new Object[] {method});
		
		
		return result;
	}
	
	
	public static <T> T getInstance(CglibProxyFactory f,Class<T> clazz) {
	
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(f);
		return (T) enhancer.create();
		
	}
	
	

}
