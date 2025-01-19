package com.arjun.learn.introduction;

/**
 * Dealing with Primitives
 * Their respective Wrappers
 * And respective conversions
 * Including Strings
 */
public class Wrappers {
    public static void main(String[] args)  {
        creatingWrappers();
        System.out.println("---------");

        boxingUnboxing();
        System.out.println("---------");

        comparingWrappers();
        System.out.println("---------");

        conversionFromString();
        System.out.println("---------");

        conversionToString();
        System.out.println("---------");
    }

    public static void creatingWrappers() {
        // Using constructors, deprecated since Java 9
        Integer first = new Integer(5);
        Integer second = new Integer("5");
        // Factory methods : preferred due to caching benefits
        Integer third = Integer.valueOf(5);
        // For strings, we can use value of
        Integer fourth = Integer.valueOf("5");
        // or parseInt
        Integer fifth = Integer.parseInt("5");
    }

    public static void boxingUnboxing() {
        int primitive = 100;
        Integer reference = Integer.valueOf(primitive); // boxing
        int anotherPrimitive = reference.intValue();    // unboxing

        double primitiveDouble = 10.8;
        Double wrapperDouble = primitiveDouble; // autoboxing
        double anotherPrimitiveDouble = wrapperDouble; // auto-unboxing
    }

    public static void comparingWrappers() {
        // use equalsTo and not ==
        Integer first = Integer.valueOf(5);
        Integer second = Integer.valueOf(6);
        // compares the values
        System.out.println(first.equals(second));

        // would give false, which should be the case
        Integer a = 1000, b = 1000;
        System.out.println(a == b);

        // would give true, since smaller values are cached by jvm
        // leading to same object being referenced
        Integer c = 100, d = 100;
        System.out.println(c == d);
    }

    public static void conversionFromString() {
        // To primitive
        int primitive = Integer.parseInt("53");
        // To wrapper
        Integer objectInteger = Integer.valueOf("53");
        Integer secondMethod = Integer.parseInt("53");

        // Follow the same for other types
        boolean flag = Boolean.parseBoolean("false");
    }

    public static void conversionToString() {
        // From primitive : convert to Wrapper first
        // From Wrapper : use the toString method
        Integer objectInteger = Integer.valueOf("53");
        System.out.println(objectInteger.toString());
    }
}
