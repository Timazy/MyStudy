package com.timazy.learn.javaSE.collections;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/*
*	@author : timazy
*	@date : 2019年1月28日
*	
*/
public class HashMap_s {


	public static void main(String[] args) {
		//capacity*load factor
		Map<Object, String> hashmap = new HashMap<>(20, 0.8f);
		
		/**
		 * 根据key的哈希值选择bucket，命中后以链表的形式后继
		 * 在Java 8中，如果一个bucket中碰撞冲突的元素超过某个限制(默认是8)，则使用红黑树来替换链表
		 */
		hashmap.put(null, "null value is permitted");		
		System.out.println(hashmap.get(null));
		
		//Object key
		HashMap_s study = new HashMap_s();
		Pain pain1 = study.new Pain(1, "pain1", 1.11);
		Pain pain2 = study.new Pain(2, "pain2", 2.22);
		System.out.println("pain1. hashcode="+pain1.hashCode());
		System.out.println("pain2:.hashcode="+pain2.hashCode());
		
		hashmap.put(pain1, "pain1");
		hashmap.put(pain2, "pain2");
		
		Pain pain1_t = study.new Pain(1, "pain1", 1.11);
		Pain pain2_t = study.new Pain(2, "pain2", 2.22);
		
		System.out.println("pain1_t.hashcode="+pain1_t.hashCode());
		System.out.println("pain2_t.hashcode="+pain2_t.hashCode());
		
		System.out.println("pain1_t.equals(pain1)?"+pain1_t.equals(pain1));
		System.out.println("pain2_t.equals(pain2)?"+pain2_t.equals(pain2));
		
		System.out.println("pain1_t.get="+hashmap.get(pain1_t));
		System.out.println("pain2_t.get="+hashmap.get(pain2_t));
	}
	
	/**
	 * 计算hash：
	 * h=hashCode() -> 1111 1111 1111 1111      1111 0000 1110 1010
	 * h>>>16    	     ->  0000 0000	0000	0000		1111 1111 1111 1111
	 * hash = h^(h.hashCode()) -> 1111 1111 1111 1111    0000 1111 0001 0101
	 * 计算下标：(n - 1)&hash,由于开始数量很小（20->32 2的倍数）最后只4位有关，这样可以充分利用高低位，减小碰撞
	 * 
	 * 扩容（resize）：
	 * 一个bucket容量超过capacity*load factor时，扩容为原来的两倍
	 * 扩容后无需重新计算hash值，只需根据n-1和hash重叠的新一位判断是否需要位置+32
	 * 
	 */
	static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

	public class Pain{
		private int data;
		private String info;
		private double number;
		
		public Pain(int data, String info, double number) {
			super();
			this.data = data;
			this.info = info;
			this.number = number;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Pain) {
				Pain cp = (Pain) obj;
				return cp.data == this.data && cp.info != null && cp.info.equals(this.info) && cp.number == this.number;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			int result = 7;
			try {
				Field[] fields = Pain.class.getFields();
				for(Field field : fields){
					if (field.getType().isPrimitive()) {
						//boolean
						if (field.getType() == boolean.class) {
							result += field.getBoolean(this)?0:1;
						}
						//digit
						else if (field.getType() == byte.class) {
							result += field.getByte(this);
						}else if (field.getType() == char.class) {
							result += field.getChar(this);
						}else if (field.getType() == short.class) {
							result += field.getShort(this);
						}else if (field.getType() == int.class) {
							result += field.getInt(this);
						}
						//long short
						else if (field.getType() == long.class) {
							result += field.getLong(this)^field.getLong(this)>>32;
						}else if(field.getType() == Short.class){
							result += Float.floatToIntBits(field.getShort(this));
						}
						
					}else {
						//Object include String(unChange Object)
						result += field.get(this) == null? 0 :field.get(this).hashCode();
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return result;

			
		}

		
		
	}
	
	
	
	
}
