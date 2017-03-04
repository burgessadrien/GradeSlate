package com.gradeslate.gradeslate.Backend;
import java.util.ArrayList;

public class Bookbag {
	private ArrayList<Item> items = new ArrayList<Item>();
	
	Bookbag(){}
	
	public void addItem(String type){
		Item next = new Item(type);
		items.add(next);
	}
	
	public Item getItem(String find){
		for(Item found:items)
			if(found.getType() == find)
				return found;
		
		return null;
	}
	
	public int getTotalCost(){
		int sum = 0;
		for(Item cost:items)
			sum += cost.getCost();
		return sum;
	}
	
	//more methods to be added later
}
