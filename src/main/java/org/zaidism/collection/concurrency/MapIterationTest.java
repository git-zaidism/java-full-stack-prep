package org.zaidism.collection.concurrency;

import java.util.concurrent.*;
import java.util.Hashtable;
import java.util.Map;

//Explanation of the Code:
//Concurrent Map Modifications:
//Two threads (NUM_THREADS = 2) are concurrently inserting data into the map, each thread adding NUM_OPERATIONS key-value pairs.
//The map will be modified while the main thread is iterating over it.
//        Iteration:
//The main thread starts iterating over the map (map.entrySet()), simulating a delay with Thread.sleep(1) to allow other threads to modify the map.
//The output of the iteration shows the state of the map at that moment, which may not reflect all changes made by the other threads immediately.
//Expected Behavior:
//For ConcurrentHashMap: You will not see a ConcurrentModificationException. However, the iteration may not reflect all changes. The output might show keys and values in an inconsistent order or with missing keys because it provides a weakly consistent view of the map.
//For Hashtable: You might see a ConcurrentModificationException or inconsistent behavior if the map is modified while iterating.

public class MapIterationTest {

    private static final int NUM_THREADS = 2; // Number of threads modifying the map
    private static final int NUM_OPERATIONS = 1000; // Number of operations per thread

    public static void main(String[] args) throws InterruptedException {
        // Test with ConcurrentHashMap
        System.out.println("Testing ConcurrentHashMap...");
        testIteration(new ConcurrentHashMap<>());

        // Test with Hashtable
        System.out.println("Testing Hashtable...");
        testIteration(new Hashtable<>());
    }

    private static void testIteration(Map<Integer, Integer> map) throws InterruptedException {
        // Create a thread pool to simulate concurrent writes and reads
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // Submit tasks to modify data concurrently
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 0; j < NUM_OPERATIONS; j++) {
                    map.put(threadId * NUM_OPERATIONS + j, threadId * NUM_OPERATIONS + j);
                }
            });
        }

        // Start iterating over the map in the main thread
        Thread iterationThread = new Thread(() -> {
            try {
                System.out.println("Iteration started...");
                // Iterating over the map (concurrent changes might occur)
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    // Simulate delay while iterating to allow other threads to modify the map
                    Thread.sleep(1);

                    // Print the current key-value pair being processed
                    System.out.println("Iterating: " + entry.getKey() + " => " + entry.getValue());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the iteration thread
        iterationThread.start();

        // Wait for the iteration thread to finish
        iterationThread.join();

        // Shut down the executor and wait for all threads to finish
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}

