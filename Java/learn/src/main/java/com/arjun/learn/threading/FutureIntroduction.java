package com.arjun.threading;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

public class FutureIntroduction {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        introduction();
        cancellingTask();
        invokeFunctions();
    }

    public static void introduction() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> generator = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 700000;
        };

        // executor returns future if callable is provided
        Future<Integer> future = executor.submit(generator);

        // to check if task is done or not
        System.out.println(future.isDone());

        // blocks current thread until the execution ends
        // or there is an exception
        // throws ExecutionException
        // throws InterruptedException
        int result = future.get();

        // or you can wait for some time and proceed without the result
        // if task is not executed in time
        // int result = future.get(10, Timeunit.SECONDS);
    }

    public static void cancellingTask() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> generator = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 700000;
        };

        // executor returns future if callable is provided
        Future<Integer> future = executor.submit(generator);

        // attempt to cancel will fail if
        // a call to cancel was already made
        future.isCancelled(); // check if task was already cancelled or not
        // the task has completed
        // task could not be cancelled
        // true : stops an executing task
        // false : stops a task from running, does not stop an already executing task
        future.cancel(true);
        // cancellation is only guaranteed if the executing thread is
        // handling InterruptionException by checking isInterrupted
    }

    public static void invokeFunctions() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> callables =
                List.of(() -> 1000, () -> 2000, () -> 1500); // three "difficult" tasks

        // submit all callables and obtain a list of futures
        Integer sum = executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException exception) {
                        System.out.println(exception.toString());
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }
}
