package com.rick.learn.javaSE.Clazz.classloader.imp;

import java.io.Serializable;
import com.rick.learn.javaSE.Clazz.classloader.inf.DynaFunc;

/*
*	@author : Rick
*	@date : 2019年4月23日
*	
*/
public class FuncLogic1 implements DynaFunc,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object doWork(int part) {
		switch (part) {
		case 1:
			return "result:"+part;
		case 2:
			return "result:"+part;
		default:
			return "default:"+part;
		}
		
	}

}
