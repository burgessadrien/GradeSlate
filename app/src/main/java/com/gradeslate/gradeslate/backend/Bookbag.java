package com.gradeslate.gradeslate.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Bookbag implements Serializable {
    private ArrayList<Item> items;

    Bookbag() {
        this.items = new ArrayList();
    }

    public Boolean addItem(String type) {
        if(type != "") {
            Item newish= new Item(type);
            this.items.add(newish);
            return true;
        }
        return false;
    }

    public Item getItem(int position) {
        if(items.size() != 0){
            return items.get(position);
        }
        return null;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public int getTotalCost() {
        int sum = 0;
        Iterator it = this.items.iterator();
        while (it.hasNext()) {
            sum += ((Item) it.next()).getCost();
        }
        return sum;
    }
}
