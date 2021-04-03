package com.arjun.threading.examples;

import java.util.concurrent.Callable;

public class Miscellaneous {
    public static void main(String[] args) {

        Callable<Callable<Integer>> callable = () -> () -> {
            return 1;
        };
        System.out.println(determineCallableDepth(callable));
    }

    public static int determineCallableDepth(Callable callable) {
        try {
            return 1+ determineCallableDepth((Callable) callable.call());
        } catch (Exception exception) {
            return 1;
        }
    }
}
