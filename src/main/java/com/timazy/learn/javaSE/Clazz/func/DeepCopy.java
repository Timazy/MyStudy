package com.timazy.learn.javaSE.Clazz.func;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
*	@author : Rick
*	@date : May 15, 2019
*	
*/
public class DeepCopy {

	
	@SuppressWarnings("unchecked")
	public static <T> T  deepCopy(T object) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(object);
		
		ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		return (T) objectInputStream.readObject();
		
	}
	
}
