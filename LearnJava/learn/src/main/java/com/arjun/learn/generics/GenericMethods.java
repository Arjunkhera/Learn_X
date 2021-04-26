package com.arjun.generics;

import java.awt.print.Book;

public class GenericMethods {

    public static <T> T doSomething(T t) {
        return t;
    }

    public static <E> int length(E[] array) {
        return array.length;
    }

    public static <E> void print(E[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // using two generic parameters
    public static <T, U> void method(T t, U u) {
        // do something
    }

    public <T> T getParameterizedObject(T t) {
        return t;
    }
}