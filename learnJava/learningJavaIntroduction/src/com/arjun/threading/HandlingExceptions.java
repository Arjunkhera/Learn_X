package com.arjun.threading;

public class HandlingExceptions {

    // Exceptions produced in thread if not handled will
    // terminate the thread. However, the thread that started
    // the terminal thread will not terminate.

    // Exception in main thread will give exit code 1 : Error
    // However, it would lead to termination of the thread already started
    // The process would wait for them to finish
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new CustomThread();
        thread.start();
        thread.join(); // wait for thread with exception to terminate

        System.out.println("I am printed!"); // this line will be printed
    }

    public static class CustomThread extends Thread {
        @Override
        public void run() {
            System.out.println(2 / 0);
        }
    }
}
