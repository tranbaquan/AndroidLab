package com.tranbaquan.firstapp.lab2.model;

public class FullTimeEmployee extends Employee {
    @Override
    public double salary() {
        return 500 * workingDay;
    }
}
