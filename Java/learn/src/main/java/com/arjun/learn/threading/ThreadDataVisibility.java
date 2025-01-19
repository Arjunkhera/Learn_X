package com.arjun.threading;

public class ThreadDataVisibility {

    // Reading values of long and double is not atomic
    // They are 64 bit, it is possible that only 32 bits are
    // modified by one thread and hence another thread
    // read in between. Use Volatile keyword to make
    // them atomic

    // Inconsistencies between thread can also arise due
    // to incorrect ordering for modification of shared data
    // Thread A
    // int x = 0;
    // number += 5;
    // Thread B
    // System.out.println(number)
    // could print either 0 or 5. Cannot say

    public static void main(String[] args) throws InterruptedException {
        // In order to prevent inconsistency, force ordering
        // through joins

        Counter counter = new Counter();
        Thread first = new MyThread(counter);
        Thread second = new MyThread(counter);

        first.start();
        // pause the main thread
        first.join();

        second.start();
        second.join();

    }

    public static class Counter {
        private int value = 0;

        public void increment() {
            value++;
        }

        public int getValue() {
            return value;
        }
    }

    public static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }
}
