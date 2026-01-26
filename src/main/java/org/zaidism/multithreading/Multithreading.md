# Multithreading in Java

## What is thread?

Thread is small part of a program/process. Threads share data and address space in a multi-threaded environment hence they are light weight.

---

## Why we use multi-threading?

In order utilize maximum time of CPU and reduce the Ideal time we use multi-threading. Example sending data in kinesis can be your multi-threaded process and you can return the response and don't wait to complete the sending data part through kinesis.

---

## main() thread

- When any java program starts its execution it runs under main() thread. All of the other threads runs under main() are child thread of main()
- main() is a user thread
- main() thread can complete it's execution & other user threads can complete their execution.

---

## Daemon Thread

In Java, daemon threads are threads that run in the background and provide services to user threads and application components. The JVM terminates when all user threads finish their execution, but it doesn't wait for daemon threads to complete. If there are only daemon threads remaining in the program, the JVM exits immediately, regardless of their state.

### Characteristics:

- They are designed to provide background services and are not critical to the main application.
- Daemon threads do not prevent the JVM from exiting, even if they are still running.

### Use Cases:

- **Garbage Collection (GC):** The JVMs garbage collector is often implemented as a daemon thread. It runs in the background to clean up unreferenced objects without blocking the execution of the main program.
- **Automatic Resource Management:** Daemon threads can be used for tasks like automatic resource cleanup, periodic maintenance tasks, or background monitoring.

**Example:** See `DaemonThreadExample.java` - you can remove setDaemon to false and see the output difference.

---

## Which way is the better for implementing thread?

- With Java 8 version we can avoid both and directly use functional interface to implement run method.
- But if I have to choose between the above two, I will go with Runnable interface. This is because Java doesn't support multiple class inheritance, and I want to avoid restricting my class from extending other classes.

---

## Thread Functionalities in Java

In Java, threads are primarily used for the following functionalities:

1. Executing a single task using a single thread.
2. Executing a single task using multiple threads.
3. Executing multiple tasks using a single thread. *(Note: This is not possible; consider the example of a VLC video player where executing only audio, video, and timer on a single thread can lead to inconsistent user experience.)*
4. Executing multiple tasks using multiple threads.

---

## How to implement deadlock?

1. Create two lock objects
2. Create two threads and use nested synchronized block in both of the threads
3. Put some delay between the synchronized blocks using sleep
4. Sequence of Lock should match for both the threads.

**Examples:** See `DeadlockExample.java` and `NoDeadlockExample.java`

---

## Synchronization

### What is synchronization & How to achieve synchronization?

- There could be a situation where it is desirable that only one thread can access to shared resource (also called as critical section) at a time.
- If more than one thread try to access a shared resource at a time then the situation is called as **Race condition**.
- **Example:** If we create two threads and one thread adds elements in the list and one thread removes elements from the list then it provide inconsistent result or we might get an exception.
- In order to achieve synchronization among multiple threads we need to use `synchronized` keyword on our shared resources/critical section.

### Types of synchronization:

1. Synchronized Method
2. Synchronized Block
3. Static synchronization

### Synchronized Block and Method

**Reference:** `Synchronization.java`

When applying synchronization at method level, it will allow only one thread (t1) to execute completely at a time & till the time thread t2 will be waiting.

#### Example Scenario:

```java
synchronized bookSeats(int noOfSeats) {
   // 200 lines of code
   // code to be synchronized or critical section
   // 200 lines like sending something to kinesis
   return response;
}
```

In this case thread t1 will complete its execution and thread t2 has to wait until thread 1 completes its execution. This is not the ideal way to utilize CPU, so in order to tackle the situation we should use synchronized block on critical section or shared resources.

### Static Synchronization

If a static method of a static or non-static class needs to be synchronized, and we want to use synchronized block, we can't use `this` keyword to put the lock on critical section/shared resource. Instead, we need to modify the lock with `ClassName.class`.

**Reference:** See comments in `Synchronization.java` and `Singleton.java`

**Important Note:** We can also apply `synchronized` keyword at method level for static methods. If we try to put `new String()` and `new Object()` as a lock on static method, you will not get a compilation error but the block will not be synchronized and output will be inconsistent/wrong.

### Best practice: Method level vs Block level

- If we want the whole method to be synchronized then synchronized method makes sense, else synchronized block is the better way to go with.

---

## Atomic Integer

In the context of threads, `AtomicInteger` in Java ensures atomicity of operations, meaning that operations performed on it are indivisible and appear to be instantaneous from the perspective of other threads. This ensures thread safety when multiple threads access and modify the same `AtomicInteger` instance concurrently.

### How AtomicInteger ensures atomicity:

1. **Atomic Operations:** `AtomicInteger` provides atomic operations like `incrementAndGet()`, `decrementAndGet()`, `addAndGet()`, etc., which perform their respective operations atomically without the need for explicit synchronization.

2. **Compare-and-Set Operations:** Methods like `compareAndSet()` allow threads to update the value of the `AtomicInteger` only if the current value matches the expected value. This ensures that modifications are made only when the AtomicInteger is in the expected state.

3. **Lock-Free:** `AtomicInteger` operations are implemented using low-level atomic hardware instructions or compare-and-swap (CAS) algorithms, which do not require locking mechanisms like `synchronized` blocks or `ReentrantLock`. This avoids potential contention and overhead associated with locks.

### Example:

See `AtomicIntegerExample.java`

In this example, two threads concurrently increment the `AtomicInteger` `counter` by 1000 each. Due to the atomicity of `incrementAndGet()` method, the final counter value will always be 2000, even in a multithreaded environment. This demonstrates the thread safety provided by `AtomicInteger` in Java.

---

## The join() Method

In Java, the `join()` method is used to wait for a thread to finish its execution before proceeding with the execution of the current thread.

### Example Usage:

```java
thread1.join();
thread2.join();
```

These lines are ensuring that the main thread (the thread that executes the `main()` method) waits for `thread1` and `thread2` to complete their execution before proceeding further.

### How it works:

1. When `thread1.join()` is called, the main thread pauses its execution and waits for `thread1` to complete.
2. Similarly, when `thread2.join()` is called, the main thread pauses again and waits for `thread2` to complete.
3. Once both `thread1` and `thread2` have finished their execution, the main thread resumes its execution.

By using `join()`, we ensure that the final output is printed only after all the threads (in this case, `thread1` and `thread2`) have finished their respective tasks. This is important for cases where we need to perform some actions after the completion of multiple threads.

---
