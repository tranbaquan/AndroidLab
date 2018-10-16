package com.tranbaquan.firstapp.lab3.model;

public class Pen extends Product {
    public Pen(String id, String name) {
        super(id, name);
        this.itemType = ItemType.PEN;
    }
}
