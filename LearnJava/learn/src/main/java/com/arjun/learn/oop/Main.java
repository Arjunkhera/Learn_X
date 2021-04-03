package com.arjun.oop;

import com.arjun.oop.modifiers.InitialisationBlocks;

// example of static imports
import com.arjun.oop.StaticOverriding.*;

public class Main {
    public static void main(String[] args) {
        //initialisationBlocks();
        //staticOverridingTest();
        //runTimePolymorphism();
    }

    public static void initialisationBlocks() {
        InitialisationBlocks first = new InitialisationBlocks();
        InitialisationBlocks second = new InitialisationBlocks();

        first.print();
        second.print();
    }

    public static void staticOverridingTest() {
        System.out.println("Object: static type Base; runtime type Child:");
        Base base = new Child();
        base.printValue();
        base.nonStatPrintValue();
        System.out.println("Object: static type Child; runtime type Child:");
        Child child = new Child();
        child.printValue();
        child.nonStatPrintValue();
        System.out.println("Class: Child static call:");
        Child.printValue();
        System.out.println("Class: Base static call:");
        Base.printValue();
        System.out.println("Object: static/runtime type Child -- call static from non-static method of Child:");
        child.localIndirectStatMethod();
        System.out.println("Object: static/runtime type Child -- call static from non-static method of Base:");
        child.nonLocalIndirectStatMethod();
    }

    public static void runTimePolymorphism() {
        Employee programmer = new Programmer();
        Employee manager = new Manager();
        Employee employee = new Employee();

        programmer.speaks();
        manager.speaks();
        employee.speaks();
    }
}
