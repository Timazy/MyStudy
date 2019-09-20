package com.timazy.learn.javaSE.Clazz.classloader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.timazy.learn.javaSE.Clazz.classloader.imp.FuncLogic1;
import com.timazy.learn.javaSE.Clazz.classloader.inf.DynaFunc;

/*
*	@author : Rick
*	@date : 2019年4月23日
*	
*/
public class DynaClassLoader<T> extends ClassLoader{

	@SuppressWarnings("unchecked")
	@Override
	public Class<?> findClass(String name){
		try {
			return super.findClass(name);
		} catch (ClassNotFoundException e) {
			byte[] clazz_byte = resolveClass(name);
			super.defineClass(name, clazz_byte, 0, clazz_byte.length);
			try {
				return super.findClass(name);
			} catch (ClassNotFoundException e1) {
				return null;
			}
		}
		
	}
	
	public byte[] resolveClass(String name){
		
		
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		try {
			
			int b;
			while((b = inputStream.read()) != -1){
				bout.write(b);
			}
			return bout.toByteArray();
		} catch (Exception e) {
			return null;
		}finally{
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (bout != null) {
					bout.close();
				}
			} catch (IOException e) {
			}
		}
		
	}
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//		DynaClassLoader<DynaFunc> classLoader = new DynaClassLoader<DynaFunc>();
//		Class<?> clazz = classLoader.findClass(FuncLogic1.class.getName());
//		if (clazz.isInstance(DynaFunc.class)) {
//			FuncLogic1 logic1 = (FuncLogic1) clazz.newInstance();
//			Object result = logic1.doWork(1);
//			System.out.println(result.toString());
//		}
		
		
		
		
		FuncLogic1 logic1  = new FuncLogic1();
		try {
			System.out.println(System.currentTimeMillis());
			byte[] bytes = serialize(logic1);
			DynaFunc func = (DynaFunc) resolve(bytes);
			System.out.println(System.currentTimeMillis());
			Object object = func.doWork(1);
			System.out.println(object.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static byte[] serialize(Object b) throws IOException{
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(b);
		byte[] bytes = byteArrayOutputStream.toByteArray();
		return bytes;
	}
	
	public static Object resolve(byte[] bytes) throws IOException, ClassNotFoundException{
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		return objectInputStream.readObject();

	}
	

}
