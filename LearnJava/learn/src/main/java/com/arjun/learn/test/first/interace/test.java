package com.arjun.test.first.interace;

public interface test {
    int a = 10;

    void first();
    default void second() {
    }

    static void third() {

    }
}