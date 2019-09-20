package com.timazy.learn.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerOperation implements Operation {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	

	
	public void start(Method method) {

		System.out.println("start args :"+method);
		//logger.info("------start method------");
	}

	public void end(Method method) {

		System.out.println("end args :"+method);
		//logger.info("------end method------");
	}
	
}
