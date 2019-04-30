package com.timazy.learn.javaSE.Clazz.classloader.pojo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;

/*
*	@author : Rick
*	@date : 2019年4月23日
*	
*/
public class Pojo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -673004019036918033L;
	public String data;
	public long id;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		System.out.println(System.currentTimeMillis());
		Pojo pojo = new Pojo();
		pojo.setData("aa");
		pojo.setId(2000);
		Field field = pojo.getClass().getField("id");
		System.out.println(System.currentTimeMillis());
		long id = field.getLong(pojo);
		System.out.println(System.currentTimeMillis());
		System.out.println(id);
	}
	
	
}
