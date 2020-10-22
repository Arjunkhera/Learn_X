package com.arjun.oop;

class Programmer extends Employee {
    protected String[] programmingLanguages;

    public Programmer() {

    }

    public Programmer(String[] programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String[] programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    @Override
    public void speaks() {
        System.out.println("I am an awesome programmer");
    }
}