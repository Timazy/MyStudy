package com.timazy.learn.abtest.entity;
/*
*	@author : Rick
*	@date : 2019年4月29日
*	
*/

import java.util.LinkedList;
import java.util.List;
import com.timazy.learn.abtest.strategy.Strategy;

public class Layer {

	long domainId;
	long layerId;
	
	
	String name;
	
	Strategy strategy;
	
	String key;
	
	long from;
	long to;
	
	List<Exp> exps = new LinkedList<>();

	
	
	public Layer(long domainId, long layerId, Strategy strategy, String key,long from,long to) {
		super();
		this.domainId = domainId;
		this.layerId = layerId;
		this.strategy = strategy;
		this.key = key;
		this.from = from;
		this.to = to;
	}

	public Layer(long domainId, long layerId, Strategy strategy, String key) {
		super();
		this.domainId = domainId;
		this.layerId = layerId;
		this.strategy = strategy;
		this.key = key;
	}
	
	public long getFrom() {
		return from;
	}



	public void setFrom(long from) {
		this.from = from;
	}



	public long getTo() {
		return to;
	}



	public void setTo(long to) {
		this.to = to;
	}



	public long getDomainId() {
		return domainId;
	}

	public void setDomainId(long domainId) {
		this.domainId = domainId;
	}

	public long getLayerId() {
		return layerId;
	}

	public void setLayerId(long layerId) {
		this.layerId = layerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public String getKey() {
		return key;
	}

	public List<Exp> getExps() {
		return exps;
	}

	public void setExps(List<Exp> exps) {
		this.exps = exps;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	
	
	
}
