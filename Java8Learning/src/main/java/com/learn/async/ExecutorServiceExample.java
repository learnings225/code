package com.learn.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 */
public class ExecutorServiceExample {
    /**
     * What is ExecutorService??
     * - it is a framework provided by the JDK which simplifies the execution of tasks in asynchronous mode.
     * - Generally to speak, ExecutorService automatically provides a pool of threads and API for assigning tasks to it.
     *
     * What is the Easiest way to create ExecutorService?
     * - The easiest way to create an executor service is using one of the factory methods of the Executors class
     *
     * ExecutorService can execute Runnable and Callable tasks.
     *
     */
    public static void main(String[] args) {
        // We can instantiate ExecutorService in ways:
        // 1. using Factory methods of Executors class
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);

        // 2. Directly create ExecutorService
        ExecutorService executorService2 =
                new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>());

        // 3. Assigning tasks to executor service
        // ExecutorService can take Runnable and Callable tasks.

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's Execution";
        };

        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(callableTask);
        tasks.add(callableTask);
        tasks.add(callableTask);

        // Tasks can be assigned to the ExecutorService using several methods, including execute(),
        // which is inherited from Executor interface, and also submit, invokeAll, invokeAny

        // The execute method is void, and it doesn't give any possibility to get the result of task's execution or
        // to check the task's status (is it running or executed, etc.)
        executorService1.execute(runnableTask);

        // submit() method submits a Callable or Runnable task to an ExecutorService and returns a result of type Future.
        Future<String> future = executorService1.submit(callableTask);

        executorService1.shutdown();
        executorService2.shutdown();

    }
}
