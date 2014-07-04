package com.travelingapp.entity;
/*
 * FastFactsInfo表的实体类
 * */
public class FastFactsInfo {
	private int id;
	private int infoid;
	private String fastFacts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInfoid() {
		return infoid;
	}
	public void setInfoid(int infoid) {
		this.infoid = infoid;
	}
	public String getFastFacts() {
		return fastFacts;
	}
	public void setFastFacts(String fastFacts) {
		this.fastFacts = fastFacts;
	}
}
