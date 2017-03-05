package com.gradeslate.gradeslate.backend;

public class Item {
	
	private String type;
	private int cost = 0;
	
	Item(String type){
		this.type = type;
	}
	
	public void setCost(int cost){
		this.cost = cost;
	}
	
	public String getType(){
		return type;
	}
	
	public int getCost(){
		return cost;
	}
}
