package com.arjun.threading;

import com.arjun.threading.examples.Store;

public class ThreadInterruption {
    public static void main(String[] args) throws InterruptedException {
        interruption();
    }

    public static void interruption() throws InterruptedException {
        Thread counter = new Thread(new Store.Interruption());
        counter.start();
        Thread.sleep(5000L);
        counter.interrupt();
        counter.join();
    }
}
