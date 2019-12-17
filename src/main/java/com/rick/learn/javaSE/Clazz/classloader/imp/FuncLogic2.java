package com.rick.learn.javaSE.Clazz.classloader.imp;

import com.rick.learn.javaSE.Clazz.classloader.pojo.Pojo;
import com.rick.learn.javaSE.Clazz.classloader.inf.DynaFunc;

/*
*	@author : Rick
*	@date : 2019年4月23日
*	
*/
public class FuncLogic2 implements DynaFunc {

	@Override
	public Object doWork(int part) {
		Pojo pojo = new Pojo();
		pojo.setData("pojo data");
		pojo.setId(part);
		return pojo;
	}

}
