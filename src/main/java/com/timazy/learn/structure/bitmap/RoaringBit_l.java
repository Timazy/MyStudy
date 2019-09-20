package com.timazy.learn.structure.bitmap;

import java.util.function.Consumer;
import org.roaringbitmap.RoaringBitmap;

/*
*	@author : Rick
*	@date : May 9, 2019
*	
*/
public class RoaringBit_l {

	public static void main(String[] args) {
		
		RoaringBitmap bitmap = RoaringBitmap.bitmapOf(1,4,7,7,200);
		RoaringBitmap bitmq2 = RoaringBitmap.bitmapOf(1,4,7,3,2);
		RoaringBitmap orBitmap = RoaringBitmap.or(bitmap,bitmq2);
		RoaringBitmap andBitmap = RoaringBitmap.and(bitmap, bitmq2);
		orBitmap.forEach((Consumer<Integer>)i ->{
			System.out.print(i.intValue()+"-");
		});
		System.out.println();
		andBitmap.forEach((Consumer<Integer>)i ->{
			System.out.print(i.intValue()+"-");
		});
		System.out.println();
		System.out.println("select 1:"+bitmap.select(1));
		System.out.println("rank 7:"+bitmap.rank(7));
		bitmap.add(0);
		bitmap.add(0l,20l);
		System.out.println("position 15:"+bitmap.contains(15));
		System.out.println("select 1:"+bitmap.select(1));
		System.out.println("select 0:"+bitmap.select(1));
		//System.out.println("select 25:"+bitmap.select(25));
		System.out.print("total:"+bitmap.getCardinality());
	}
}
