package com.timazy.learn.abtest.request;

import java.util.HashMap;
import java.util.Map;
import com.timazy.learn.abtest.entity.Exp;
import com.timazy.learn.abtest.sdk.AbTestSDK;
import com.timazy.learn.abtest.strategy.Strategy;

/*
*	@author : Rick
*	@date : 2019年4月29日
*	
*/
public class Request1 {

	public static void main(String[] args) {
		
		
		
		String spm="";
		//请求初始化参数
		String key = "rick";
		Strategy strategy = Strategy.HASH;
		long domain = 1;
		Map<String, String> iMap = new HashMap<>();
		
		Exp exp = AbTestSDK.selectExpByStrategyKey(domain, strategy, key);
		if (exp != null) {
			doSomethin1(iMap, exp.getParams(), spm);
			spm += exp.getIdentification()+".";
			
			//TODO mapping 判断
			
			if (exp.getLayerId() == 2) {
				Exp exp2 = AbTestSDK.selectExpByLayer(domain, 3, iMap);
				doSomethin2(iMap, exp2.getParams(), spm);
				spm += exp2.getIdentification()+".";
			}
			
		}
		
		System.out.println(spm);
		
		
	}
	
	public static void doSomethin1(Map<String, String> iMap,String params,String spm){
		iMap.put("age", ((int)(100*(Math.random())))+"");
		System.out.println("do1{parms:"+params+"}");
	}
	public static void doSomethin2(Map<String, String> iMap,String params,String spm){
		System.out.println("do2{parms:"+params+"}");
	}
	
}
