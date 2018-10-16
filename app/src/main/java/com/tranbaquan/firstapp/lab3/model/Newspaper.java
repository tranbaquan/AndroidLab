package com.tranbaquan.firstapp.lab3.model;

public class Newspaper extends Product {
    public Newspaper(String id, String name) {
        super(id, name);
        this.itemType = ItemType.NEWSPAPER;
    }
}
