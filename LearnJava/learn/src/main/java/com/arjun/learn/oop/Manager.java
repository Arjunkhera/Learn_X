package com.arjun.oop;

class Manager extends Employee {
    protected boolean smile;

    public boolean isSmile() {
        return smile;
    }

    public void setSmile(boolean smile) {
        this.smile = smile;
    }

    @Override
    public void speaks() {
        System.out.println("I manage people");
    }
}