package com.arjun.functional.examples;

public class Account {
    private static Integer count = 0;

    private String name;
    private Double balance;
    private Integer id;

    public Account() {

    }

    public Account(String name, Double balance) {
        this.name = name;
        this.balance = balance;
        this.id = Account.count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void withdrawBalance(Integer withdrawAmount) {
        this.balance = (this.balance < withdrawAmount) ? this.balance : this.balance - withdrawAmount;
    }

    public void depositBalance(Double depositAmount) {
        if(depositAmount < 0) return;
        this.balance += depositAmount;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", id=" + id +
                '}';
    }
}
