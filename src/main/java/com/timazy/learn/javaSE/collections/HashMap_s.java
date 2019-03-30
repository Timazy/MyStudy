package com.timazy.learn.javaSE.collections;

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
		Map<String, String> hashmap = new HashMap<>(20, 0.8f);
		
		/**
		 * 根据key的哈希值选择bucket，命中后以链表的形式后继
		 * 在Java 8中，如果一个bucket中碰撞冲突的元素超过某个限制(默认是8)，则使用红黑树来替换链表
		 */
		hashmap.put(null, "null value is permitted");
		System.out.println(hashmap.get(null));
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

}
