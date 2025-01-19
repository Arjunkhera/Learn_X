package com.arjun.learn.junit;

public class Address {
    String owner;
    String street;

    public Address(String owner, String street) {
        this.owner = owner;
        this.street = street;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
