package com.arjun.introduction;

public class Variables {

    public static void main(String[] args) {
        // Declaration
        int a;
        // Initialisation
        a = 12;
        // Declaration and Initialisation
        int b = 13;

        // Automatic Type Inference : Use var
        // Valid for versions including and after java 11
        var checkVariable = "autoAssign";
        System.out.println(checkVariable);
    }

    // Primitive types have their values directly stored in the stack
    // Reference types have their addresses stored for their location in the heap
    // Only reference types can point to null

    public static void primitiveTypes() {
        // A total of eight primitive types

    }

    public static void referenceTypes() {
        // Reference Types : usually created through new keyword
        // Name of reference types always starts with a capital letter : like String
        String referenceString = new String ("java");
        System.out.println(referenceString);

    }
}
