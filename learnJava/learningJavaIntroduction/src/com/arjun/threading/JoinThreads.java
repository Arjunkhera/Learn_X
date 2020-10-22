package com.arjun.threading;

public class JoinThreads {

    public static void main(String[] args) throws InterruptedException{
        Thread worker = new Worker();
        worker.start(); // start the worker

        Thread.sleep(100L);
        System.out.println("Do something useful");

        // if join is initiated, the current thread has to wait
        // for the specified duration
        // or infinitely if not specified
        worker.join(3000L);  // waiting for the worker
        System.out.println("The program stopped");
    }

    public static class Worker extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Starting a task");
                Thread.sleep(2000L); // it solves a difficult task
            } catch (Exception ignored) {
            }
        }
    }
}
