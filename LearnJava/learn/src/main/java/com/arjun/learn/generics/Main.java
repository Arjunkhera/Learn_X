package com.arjun.learn.generics;

public class Main {

    public static void main(String[] args) {
        introduction();
        objectsAsGeneric();
        genericMethods();
    }

    public static void introduction() {
        GenericType<Integer> obj1 = new GenericType<Integer>(10);
        GenericType<String> obj2 = new GenericType<>("abc");

        var obj3 = new GenericType<>(27);
    }

    public static void objectsAsGeneric() {
        NonGenericClass instance2 = new NonGenericClass("abc");
        // String str = instance2.get(); // Compile-time error: Incompatible types

        String str = (String) instance2.get(); // "abc"

        NonGenericClass instance3 = new NonGenericClass(123);
        String str2 = (String) instance3.get(); // throws java.lang.ClassCastException

        GenericType<String> instance4 = new GenericType<>("abc");

        String str3 = instance4.get(); // There is no type-casting here
        // Integer num = instance4.get(); // It does not compile
    }

    public static void genericMethods() {
        Integer[] array = {1, 2, 3, 4};
        int len = GenericMethods.length(array); // pass an array of Integer's

        Character[] characters = {'a', 'b', 'c'};
        GenericMethods.print(characters);

        GenericMethods instance = new GenericMethods();
        Integer value = instance.getParameterizedObject(601);
    }
}
