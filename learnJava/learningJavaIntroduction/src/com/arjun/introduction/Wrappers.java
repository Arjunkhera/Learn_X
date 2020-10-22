package com.arjun.introduction;

public class Wrappers {
    public static void main(String[] args)  {
        creatingWrappers();
        boxingUnboxing();
        comparingWrappers();
    }

    public static void creatingWrappers() {
        // Using constructors, deprecated since Java 9
        Integer first = new Integer(5);
        Integer second = new Integer("5");
        // Special methods : use the following
        Integer third = Integer.valueOf(5);
        Integer fourth = Integer.parseInt("5");
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
}
