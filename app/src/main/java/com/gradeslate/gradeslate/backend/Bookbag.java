package com.gradeslate.gradeslate.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Bookbag implements Serializable {
    private ArrayList<Item> items;

    Bookbag() {
        this.items = new ArrayList();
    }

    public void addItem(String type) {
        this.items.add(new Item(type));
    }

    public Item getItem(String find) {
        Iterator it = this.items.iterator();
        while (it.hasNext()) {
            Item found = (Item) it.next();
            if (found.getType() == find) {
                return found;
            }
        }
        return null;
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
