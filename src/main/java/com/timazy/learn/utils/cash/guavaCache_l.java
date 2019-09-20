package com.timazy.learn.utils.cash;
/*
*	@author : Rick
*	@date : May 13, 2019
*	
*/

import java.util.concurrent.TimeUnit;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.cache.Weigher;

public class guavaCache_l {

	public static LoadingCache<String, Object> getCache(){
		return Instance.cache;
	}
	
	private static class Instance{
		public static LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
				.maximumSize(1024)
				.expireAfterAccess(30,TimeUnit.SECONDS)
				.expireAfterWrite(30, TimeUnit.SECONDS)
				.maximumWeight(1000)
				.weigher(new Weigher<String, Object>() {
					@Override
					public int weigh(String key, Object value) {
						int weight = (int) Math.random()*10;
						return weight;
					}
				})
				.removalListener(new RemovalListener<String, Object>() {

					@Override
					public void onRemoval(RemovalNotification<String, Object> notification) {
						
						System.out.print(notification.getKey() + " -> "+notification.getValue());
						
					}
					
				})
				.build(new CacheLoader<String, Object>() {

					@Override
					public Object load(String key) throws Exception {
						return null;
					}
					
				});
		
		
	}
	
	
}
