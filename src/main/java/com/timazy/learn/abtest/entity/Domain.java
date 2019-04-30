package com.timazy.learn.abtest.entity;
/*
*	@author : Rick
*	@date : 2019年4月29日
*	
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Domain {

	long domainId;
	
	String name;
	
	List<Layer> heads = new LinkedList<>();
	

	Map<Long, Layer> layers = new HashMap<>();
	
	
	public Domain(long domainId) {
		super();
		this.domainId = domainId;
	}

	public long getDomainId() {
		return domainId;
	}

	public void setDomainId(long domainId) {
		this.domainId = domainId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<Layer> getHeads() {
		return heads;
	}

	public void setHeads(List<Layer> heads) {
		this.heads = heads;
	}

	public Map<Long, Layer> getLayers() {
		return layers;
	}

	public void setLayers(Map<Long, Layer> layers) {
		this.layers = layers;
	}

	
	
	
	
}
