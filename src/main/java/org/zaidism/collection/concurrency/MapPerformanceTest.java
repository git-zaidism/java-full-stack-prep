package org.zaidism.collection.concurrency;

import java.util.concurrent.*;
import java.util.Hashtable;
import java.util.Map;


//Explanation:
//Test Setup:
//NUM_THREADS is the number of threads that will perform operations concurrently.
//NUM_OPERATIONS is the number of operations each thread will perform (in this case, putting and getting values from the map).
//Test Method:
//testConcurrentMap takes a Map (either ConcurrentHashMap or Hashtable) and performs a test where multiple threads concurrently perform put() and get() operations.
//The time taken for all operations to complete is measured by recording the start time and end time.
//Executor Service:
//An ExecutorService with a fixed thread pool is used to simulate concurrent threads performing operations on the map.
//Each thread runs a loop where it inserts a key-value pair into the map and retrieves it.
//Time Measurement:
//The time taken to complete the operations is printed in milliseconds for both ConcurrentHashMap and Hashtable.
public class MapPerformanceTest {

    private static final int NUM_THREADS = 10;
    private static final int NUM_OPERATIONS = 100000;

    public static void main(String[] args) throws InterruptedException {
        // Test with ConcurrentHashMap
        System.out.println("Testing ConcurrentHashMap...");
        long concurrentHashMapTime = testConcurrentMap(new ConcurrentHashMap<>());
        System.out.println("ConcurrentHashMap Time: " + concurrentHashMapTime + " ms");

        // Test with Hashtable
        System.out.println("Testing Hashtable...");
        long hashtableTime = testConcurrentMap(new Hashtable<>());
        System.out.println("Hashtable Time: " + hashtableTime + " ms");
    }

    private static long testConcurrentMap(Map<Integer, Integer> map) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        //map.put(null, null); this line will throw null pointer for both hashtable and concurrentHashMap

        // Create a thread pool to simulate concurrent writes and reads
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // Submit tasks to write data concurrently
        for (int i = 0; i < NUM_THREADS; i++) {
            executor.submit(() -> {
                for (int j = 0; j < NUM_OPERATIONS; j++) {
                    map.put(j, j);
                    map.get(j);
                }
            });
        }

        // Shut down the executor and wait for all threads to finish
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
