package com.tranbaquan.firstapp.lab3.model;

public class Book extends Product {

    public Book(String id, String name) {
        super(id, name);
        this.itemType = ItemType.BOOK;
     }
}
