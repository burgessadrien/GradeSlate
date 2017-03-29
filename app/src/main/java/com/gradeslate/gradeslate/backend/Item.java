package com.gradeslate.gradeslate.backend;

import java.io.Serializable;

public class Item implements Serializable {
    private int cost;
    private String type;

    Item(String type) {
        this.cost = 0;
        this.type = type;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getType() {
        return this.type;
    }

    public int getCost() {
        return this.cost;
    }
}
