package com.arjun.oop.abstractIntroduction;

class Dog extends Pet {

    // It can have additional fields as well

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void say() {
        System.out.println("Woof!");
    }
}