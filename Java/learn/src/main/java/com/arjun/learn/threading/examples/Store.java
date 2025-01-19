package com.arjun.learn.threading.examples;

public class Store {

    // first method of creating a thread
    public static class HelloThread extends Thread {

        public HelloThread(String threadName) {
            super(threadName);
        }

        @Override
        public void run() {
            String helloMsg = String.format("Hello, i'm %s", getName());
            System.out.println(helloMsg);
        }
    }

    // second method of creating a thread
    public static class HelloRunnable implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            String helloMsg = String.format("Hello, i'm %s", threadName);
            System.out.println(helloMsg);
        }
    }

    public static class Interruption implements Runnable {
        @Override
        public void run() {
            System.out.println("Start counting");
            int i = 1; // the first number to print

            try {
                while (!Thread.interrupted()) {
                    System.out.println(i);
                    i++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Sleeping was interrupted");
            }
            System.out.println("Finishing");
        }
    }

    // class with synchronisation methods
    public static class SyncClass {
        private String name;

        public static synchronized void  synchronisedStatic() {
            String threadName = Thread.currentThread().getName();
            System.out.printf("%s entered the method%n", threadName);
            System.out.printf("%s leaves the method%n", threadName);
        }

        public synchronized void  synchronisedInstance() {
            String threadName = Thread.currentThread().getName();
            System.out.printf("%s entered the method of %s%n", threadName, name);
            System.out.printf("%s leaves the method of %s%n", threadName, name);
        }

        public static void staticMethod() {
            // unsynchronized code
            synchronized (SyncClass.class) { // synchronization on the class
                // synchronized code
            }
        }

        public void instanceMethod() {
            // unsynchronized code
            synchronized (this) { // synchronization on this instance
                // synchronized code
            }
        }
    }

    // declare objects to use as locks for requirement of multiple montiors
    public static class MultipleMonitors {
        private int numberOfCallingMethod1 = 0;
        private int numberOfCallingMethod2 = 0;

        final Object lock1 = new Object(); // an object for locking
        final Object lock2 = new Object(); // another object for locking

        public void method1() {
            System.out.println("method1...");

            synchronized (lock1) {
                numberOfCallingMethod1++;
            }
        }

        public void method2() {
            System.out.println("method2...");

            synchronized (lock2) {
                numberOfCallingMethod2++;
            }
        }

    }
}
