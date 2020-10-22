package com.arjun.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsIntroduction {
    public static void main(String[] args) {
        introduction();
    }

    public static void introduction() {
        // use number of processors as a yardstick for deciding
        // number of threads in a thread pool
        int poolSize = Runtime.getRuntime().availableProcessors();
        final int NUMBER_OF_TASKS = 10;

        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                String taskName = "task-" + taskNumber;
                String threadName = Thread.currentThread().getName();
                System.out.printf("%s executes %s\n", threadName, taskName);
            });
        }
        executor.shutdown();
    }

    public static void terminatingThreads() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // does not take any new tasks
        executor.shutdown();

        // shutdown does not block the running thread
        // you can use await to make the current thread wait for a certain
        // time period or thread shutdown, whichever comes first
        boolean terminated = executor.awaitTermination(60, TimeUnit.MILLISECONDS);

        // stops all executing threads, returns threads in queue
        System.out.println(executor.shutdownNow());
    }

    public static void blockRunningThread() throws InterruptedException {
        // current thread is not blocked by submit
        // use awaitTermination : it waits for
        // timeout or the executing thread to finish
        // whichever comes first

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(60);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        boolean terminated = executorService.awaitTermination(60, TimeUnit.MILLISECONDS);

        if (terminated) {
            System.out.println("The executor was successfully stopped");
        } else {
            System.out.println("Timeout elapsed before termination");
        }
    }

    public static void executorTypes() {
        // single thread executor, for rarely submitted tasks and small async operations
        ExecutorService singleThread = Executors.newSingleThreadExecutor();

        // executor with a growing pool, resizes depending on how many task are incoming
        // situation can get out of hand if too many threads are spawned
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();

        // schedules threads bases on init delay and scheduler timer
        ScheduledExecutorService scheduledThread = Executors.newSingleThreadScheduledExecutor();
        scheduledThread.scheduleAtFixedRate(() ->
            System.out.println(System.currentTimeMillis()),
                1000,
                1000,
                TimeUnit.MILLISECONDS);
    }
}
