package com.rick.learn.structure.bitmap;

import java.util.BitSet;

/*
*	@author : Rick
*	@date : May 13, 2019
*	
*/
public class BitSet_l {

	public static void main(String[] args) {
		
		BitSet bitSet = new BitSet(10);
		bitSet.set(0, 2);
		for (int i = 0; i < bitSet.length(); i++) {
			System.out.print(bitSet.get(i));
		}
	}
}
