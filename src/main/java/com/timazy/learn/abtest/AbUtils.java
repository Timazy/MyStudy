package com.timazy.learn.abtest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
*	@author : Rick
*	@date : Jul 6, 2019
*	
*/
public class AbUtils {

	
	
	public static void main(String[] args) {
		
		BigDecimal ctr = new BigDecimal("0.0036646057323499073");
		BigDecimal rpc = new BigDecimal("73.52366222597577");
		BigDecimal seller3 = new BigDecimal("51265.1698");
		BigDecimal seller7 = new BigDecimal("127485.9809");
		BigDecimal seller15 = new BigDecimal("311073.5975");
		BigDecimal goods7 = new BigDecimal("23.5623");
		BigDecimal goods30 = new BigDecimal("126.0473");
		BigDecimal goodDSR = new BigDecimal("4.821243");
		BigDecimal shopDSR = new BigDecimal("4.929896");
		String ctrWeight = "5";
		String rpcWeight = "0.01";
		String seller3Weight = "0.0025";
		String seller7Weight = "0.0015";
		String seller15Weight = "0.001";
		String goods7Weight = "0.0075";
		String goods30Weight = "0.0025";
		String goodDSRWeight = "0.01";
		String shopDSRWeight = "0.01";
		
		
		System.out.println("指标          函数                结果                                 权重          加权结果");
		System.out.println("ctr             x                      "+ctr+"          "+ctrWeight+"          "+ctr.multiply(new BigDecimal(ctrWeight)).setScale(5,BigDecimal.ROUND_HALF_UP));
		System.out.println("rpc             log(x+1)          "+Math.log10(rpc.add(new BigDecimal(1)).doubleValue())+"         "+rpcWeight+"          "+new BigDecimal(Math.log10(rpc.add(new BigDecimal(1)).doubleValue())).multiply(new BigDecimal(rpcWeight)).setScale(5,BigDecimal.ROUND_HALF_UP));
		System.out.println("seller3       log(x+1)          "+Math.log10(seller3.add(new BigDecimal(1)).doubleValue())+"         "+seller3Weight+"        "+new BigDecimal(Math.log10(seller3.add(new BigDecimal(1)).doubleValue())).multiply(new BigDecimal(seller3Weight)).setScale(5,BigDecimal.ROUND_HALF_UP));
		System.out.println("seller7       log(x+1)          "+Math.log10(seller7.add(new BigDecimal(1)).doubleValue())+"         "+seller7Weight+"        "+new BigDecimal(Math.log10(seller7.add(new BigDecimal(1)).doubleValue())).multiply(new BigDecimal(seller7Weight)).setScale(5,BigDecimal.ROUND_HALF_UP));
		System.out.println("seller15     log(x+1)          "+Math.log10(seller15.add(new BigDecimal(1)).doubleValue())+"         "+seller15Weight+"        "+new BigDecimal(Math.log10(seller15.add(new BigDecimal(1)).doubleValue())).multiply(new BigDecimal(seller15Weight)).setScale(5,BigDecimal.ROUND_HALF_UP));
		System.out.println("goods7      log(x+1)          "+Math.log10(goods7.add(new BigDecimal(1)).doubleValue())+"         "+goods7Weight+"        "+new BigDecimal(Math.log10(goods7.add(new BigDecimal(1)).doubleValue())).multiply(new BigDecimal(goods7Weight)).setScale(5,BigDecimal.ROUND_HALF_UP));
		System.out.println("goods30    log(x+1)          "+Math.log10(goods30.add(new BigDecimal(1)).doubleValue())+"         "+goods30Weight+"        "+new BigDecimal(Math.log10(goods30.add(new BigDecimal(1)).doubleValue())).multiply(new BigDecimal(goods30Weight)).setScale(5,BigDecimal.ROUND_HALF_UP));
		System.out.println("goodDSR   log(x+1)          "+Math.log10(goodDSR.add(new BigDecimal(1)).doubleValue())+"         "+goodDSRWeight+"        "+new BigDecimal(Math.log10(goodDSR.add(new BigDecimal(1)).doubleValue())).multiply(new BigDecimal(goodDSRWeight)).setScale(5,BigDecimal.ROUND_HALF_UP));
		System.out.println("shopDSR   log(x+1)          "+Math.log10(shopDSR.add(new BigDecimal(1)).doubleValue())+"         "+shopDSRWeight+"        "+new BigDecimal(Math.log10(shopDSR.add(new BigDecimal(1)).doubleValue())).multiply(new BigDecimal(shopDSRWeight)).setScale(5,BigDecimal.ROUND_HALF_UP));

		
	}
}
