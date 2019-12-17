package com.rick.learn.abtest.entity;
/*
*	@author : Rick
*	@date : 2019年4月29日
*	
*/
public class Exp {

	long expId;
	
	long layerId;
	
	long from;
	long to;
	
	long identification;
	
	String params;
	
	String layer_mapping;

	
	
	public Exp(long expId, long layerId, long from, long to, long identification,
			String params) {
		super();
		this.expId = expId;
		this.layerId = layerId;
		this.from = from;
		this.to = to;
		this.identification = identification;
		this.params = params;
	}

	

	public long getExpId() {
		return expId;
	}



	public void setExpId(long expId) {
		this.expId = expId;
	}



	public long getLayerId() {
		return layerId;
	}



	public void setLayerId(long layerId) {
		this.layerId = layerId;
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

	public long getIdentification() {
		return identification;
	}

	public void setIdentification(long identification) {
		this.identification = identification;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getLayer_mapping() {
		return layer_mapping;
	}

	public void setLayer_mapping(String layer_mapping) {
		this.layer_mapping = layer_mapping;
	}
	
	
	
}
