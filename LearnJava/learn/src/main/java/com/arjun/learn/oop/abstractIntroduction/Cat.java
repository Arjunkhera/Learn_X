package com.arjun.oop.abstractIntroduction;

class Cat extends Pet {

    // It can have additional fields as well

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void say() {
        System.out.println("Meow!");
    }
}