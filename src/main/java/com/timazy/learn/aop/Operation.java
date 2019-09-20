package com.timazy.learn.aop;

import java.lang.reflect.Method;

public interface Operation {

	void start(Method method);
	
	void end(Method method);
}
