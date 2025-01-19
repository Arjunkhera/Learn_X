package com.arjun.learn.threading.examples;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            executor.submit(new PrintIfPrimeTask(number));
        }
        executor.shutdown();
    }

    static class PrintIfPrimeTask implements Runnable {
        private final int number;

        public PrintIfPrimeTask(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            if (number > 1 && IntStream.range(2, (int) Math.sqrt(number) + 1).filter(x -> number % x == 0).count() == 0) {
                System.out.println(number);
            }
        }
    }
}

