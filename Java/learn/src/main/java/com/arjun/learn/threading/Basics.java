package com.arjun.learn.threading;

import com.arjun.learn.threading.examples.Store;

public class Basics {
    public static void main(String[] args) {
        System.out.println("Start of Main Thread");

        threadProperties();
        waysOfCreatingThread();

        System.out.println("End of Main Thread");
    }

    public static void threadProperties() {
        // fetches current running thread
        Thread t = Thread.currentThread();

        // common methods
        System.out.println("Name: " + t.getName());
        System.out.println("ID: " + t.getId());
        System.out.println("Alive: " + t.isAlive());
        System.out.println("Priority: " + t.getPriority());
        System.out.println("Daemon: " + t.isDaemon());

        t.setName("my-thread");
        System.out.println("New name: " + t.getName());
    }

    public static void waysOfCreatingThread() {
        Thread firstMethod = new Store.HelloThread("NormalThread");
        Thread secondMethod = new Thread(new Store.HelloRunnable(), "Runnable");
        Thread lambdaMethod = new Thread( () -> System.out.println("Using a lambda to create a thread. This is what overrides run"), "lambda");

        firstMethod.start();
        secondMethod.start();
        lambdaMethod.start();
    }
}
