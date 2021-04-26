package com.arjun.oop;

import java.util.Date;

class Employee extends Person {
    protected Date startDate;
    protected Long salary;

    public Employee() {

    }

    public Employee(Date startDate, Long salary) {
        this.startDate = startDate;
        this.salary = salary;
    }

    public Employee(String name, int yearOfBirth, String address, Date startDate, Long salary) {
        super(name, yearOfBirth, address);
        this.startDate = startDate;
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public void speaks() {
        System.out.println("Generic Employee");
    }
}