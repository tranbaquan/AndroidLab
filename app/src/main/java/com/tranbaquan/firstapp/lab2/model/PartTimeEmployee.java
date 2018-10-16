package com.tranbaquan.firstapp.lab2.model;

public class PartTimeEmployee extends Employee {
    @Override
    public double salary() {
        return 150 * workingDay;
    }
}
