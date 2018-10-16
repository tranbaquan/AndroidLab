package com.tranbaquan.firstapp.lab2.model;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    protected String employeeId;
    protected String employeeName;
    protected int workingDay;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    public abstract double salary();

    @Override
    public String toString() {
        return employeeId + "\t" + employeeName + "\t" + salary();
    }
}
