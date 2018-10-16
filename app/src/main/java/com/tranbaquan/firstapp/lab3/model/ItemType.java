package com.tranbaquan.firstapp.lab3.model;

public enum ItemType {
    BOOK("Book"),
    NEWSPAPER("Newspaper"),
    PEN("Pen");

    private final String type;

    ItemType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
