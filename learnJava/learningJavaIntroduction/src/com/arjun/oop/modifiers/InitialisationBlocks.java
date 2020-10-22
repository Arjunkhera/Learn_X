package com.arjun.oop.modifiers;

public class InitialisationBlocks {
    private static String stringField;
    private static final String A_STRING_CONSTANT;

    {
        System.out.println("normal initialisation start");
        stringField = "normal";
        System.out.println("normal initialisation end");
    }

    // only static fields and methods can be accessed
    static {
        System.out.println("static initialisation start");
        stringField = "static";
        A_STRING_CONSTANT = "unknown";
        System.out.println("static initialisation end");
    }

    public void print() {
        System.out.println(stringField);
    }
}
