# Java Multithreading 

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
## Thread Functionalities in Java

In Java, threads are primarily used for the following functionalities:

1. Executing a single task using a single thread.
2. Executing a single task using multiple threads.
3. Executing multiple tasks using a single thread. *(Note: This is not possible; consider the example of a VLC video player where executing only audio, video, and timer on a single thread can lead to inconsistent user experience.)*
4. Executing multiple tasks using multiple threads.

---

## 1. What is a Thread in Java? How is it different from a Process?

### What it is (Theory)
- **Process**: An independent program in execution with its own memory space.
- **Thread**: A lightweight unit of execution inside a process.
- A process can have **multiple threads** sharing the same memory.

### Key Differences

| Process | Thread |
|------|------|
| Heavyweight | Lightweight |
| Separate memory | Shared memory |
| Slow context switch | Fast context switch |
| Communication via IPC | Communication via shared variables |

---

### Real-world analogy
- Process = Restaurant
- Threads = Chefs working in the same kitchen

---

### Why it matters
Threads allow:
- Better CPU utilization
- Parallel task execution
- Faster applications

---

## 2. Different Ways to Create a Thread in Java

Java provides **multiple ways** to create and manage threads. Historically, threads were created manually, but in real-world applications, **ExecutorService is preferred**.

---

### 1. Extending the `Thread` Class

### What it is (Theory)
You create a thread by extending the `Thread` class and overriding the `run()` method.

---

### Code Example
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running using Thread class");
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
````

### Output

```
Thread running using Thread class
```

---

### Explanation

* `start()` creates a new thread
* JVM internally calls `run()`
* Task and thread logic are tightly coupled

---

### Drawbacks

* Cannot extend another class
* Not flexible for large applications

---

### 2. Implementing the `Runnable` Interface (Recommended over Thread)

### What it is (Theory)

You define the task separately and pass it to a `Thread` object.

---

### Code Example

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Thread running using Runnable");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MyTask());
        t.start();
    }
}
```

### Output

```
Thread running using Runnable
```

---

### Explanation

* Task is separated from thread
* Supports multiple inheritance
* Cleaner design

---

### 3. Using Lambda Expression (Runnable)

### What it is

A concise way to create threads using Java 8+ lambdas.

---

### Code Example

```java
public class LambdaThread {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Thread running using lambda");
        });
        t.start();
    }
}
```

### Output

```
Thread running using lambda
```

---

### Why it matters

* Less boilerplate
* Readable and modern Java style

---

### 4. Using `ExecutorService` (BEST PRACTICE)

### What it is (Theory)

`ExecutorService` is part of the **Executor Framework** that manages a **pool of reusable threads**.

Instead of creating threads manually:

* You submit tasks
* The framework handles thread creation, reuse, and lifecycle

---

### Code Example (Fixed Thread Pool)

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> {
            System.out.println("Task 1 executed by " + Thread.currentThread().getName());
        });

        executor.execute(() -> {
            System.out.println("Task 2 executed by " + Thread.currentThread().getName());
        });

        executor.shutdown();
    }
}
```

### Sample Output

```
Task 1 executed by pool-1-thread-1
Task 2 executed by pool-1-thread-2
```

---

### Explanation

* `newFixedThreadPool(2)` creates two reusable threads
* `execute()` submits tasks
* Threads are reused instead of recreated
* `shutdown()` gracefully stops the executor

---

### Why ExecutorService is Preferred in Real Applications

* Prevents creating too many threads
* Improves performance and stability
* Built-in lifecycle management
* Required for scalable systems

---

### Interview Tip

> **Never say you create threads using `new Thread()` in production.
> Always say you use `ExecutorService`.**

---

### Summary Table

| Approach        | Recommended | Use Case           |
| --------------- | ----------- | ------------------ |
| Thread class    | ❌           | Learning only      |
| Runnable        | ⚠️          | Small apps         |
| Lambda Runnable | ⚠️          | Simple tasks       |
| ExecutorService | ✅           | Real-world systems |

---

### Key Interview Takeaway

Manual thread creation is low-level.
**ExecutorService is the industry-standard way to create and manage threads in Java.**

## 3. Difference Between start() and run()

### Theory

* `start()` creates a **new thread**
* `run()` executes like a normal method

### Code Example

```java
class Test extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.run();
        t.start();
    }
}
```

**Output**

```
main
Thread-0
```

---

### Why it matters

Calling `run()` does **not** create a new thread.

---

## 4. Thread Lifecycle and States

### States

1. **New**
2. **Runnable**
3. **Running**
4. **Blocked / Waiting**
5. **Terminated**

### Flow

```
New → Runnable → Running → Waiting/Blocked → Runnable → Terminated
```

---

### Why it matters

Helps debug:

* Deadlocks
* Performance issues
* Thread starvation

---

## 5. What is Context Switching?

### Theory

Context switching is when CPU switches from one thread to another.

### Why it happens

* Limited CPU cores
* Multitasking

### Cost

* Saving thread state
* Loading another thread state

---

### Why it matters

Too many threads = performance degradation

---

## 6. What are Daemon Threads?

### Theory

* Background service threads
* JVM exits when only daemon threads remain

### Examples

* Garbage Collector
* Monitoring threads

### Code Example

```java
Thread t = new Thread(() -> {
    while(true) {
        System.out.println("Running daemon");
    }
});
t.setDaemon(true);
t.start();
```

---

### When to use

* Background cleanup
* Monitoring
* Logging

---

## 7. What is Synchronization and Why is it Needed?

### Theory

Synchronization ensures **only one thread** accesses a shared resource at a time.

### Problem: Race Condition

```java
class Counter {
    int count = 0;

    void increment() {
        count++;
    }
}
```

Multiple threads → incorrect value.

---

### Solution

```java
synchronized void increment() {
    count++;
}
```

---

### Why it matters

* Prevents data inconsistency
* Ensures thread safety

---

## 8. Synchronized Method vs Synchronized Block

### Synchronized Method

```java
synchronized void print() {}
```

Locks entire method.

---

### Synchronized Block

```java
void print() {
    synchronized(this) {
        // critical section
    }
}
```

Locks only required code.

---

### Why block is better

* Better performance
* Fine-grained locking

---

## 9. Object-Level Locking vs Class-Level Locking

### Object-Level Lock

```java
synchronized(this) {}
```

* Lock per object

---

### Class-Level Lock

```java
synchronized(MyClass.class) {}
```

* Lock shared across all objects

---

### When to use

* Object-level: Instance variables
* Class-level: Static variables

---

## 10. What is Deadlock? How to Prevent It?

### Theory

Deadlock occurs when two threads wait forever for each other’s locks.

### Example

```java
Thread A: lock1 → waits for lock2
Thread B: lock2 → waits for lock1
```

---

### Prevention

* Avoid nested locks
* Lock ordering
* Use tryLock()
* Use timeout

---

## 11. Difference Between sleep() and wait()

| sleep()               | wait()          |
| --------------------- | --------------- |
| Thread class          | Object class    |
| Does not release lock | Releases lock   |
| Time-based            | Condition-based |

---

### Code Example

```java
Thread.sleep(1000);
```

```java
synchronized(obj) {
    obj.wait();
}
```

---

## 12. What is the join() Method?

### Theory

Makes one thread wait for another to finish.

### Code Example

```java
Thread t = new Thread(() -> {
    System.out.println("Worker");
});

t.start();
t.join();
System.out.println("Main");
```

**Output**

```
Worker
Main
```

---

## 13. What is a Race Condition?

### Theory

Multiple threads modify shared data without synchronization.

### Avoid using

* synchronized
* locks
* atomic classes

---

## 14. What is the volatile Keyword?

### Theory

Ensures visibility of variable changes across threads.

```java
volatile boolean running = true;
```

### Difference from synchronization

| volatile        | synchronized           |
| --------------- | ---------------------- |
| Visibility only | Visibility + atomicity |
| Faster          | Slower                 |

---

## 15. What is ThreadLocal?

### Theory

Provides thread-confined variables.

### Example

```java
ThreadLocal<Integer> tl = new ThreadLocal<>();
tl.set(10);
System.out.println(tl.get());
```

### Use cases

* User sessions
* Transaction IDs
* Logging context

---

## 16. Callable vs Runnable

| Runnable                       | Callable            |
| ------------------------------ | ------------------- |
| No return value                | Returns value       |
| Cannot throw checked exception | Can throw exception |

---

### Example

```java
Callable<Integer> task = () -> 42;
```

---

## 17. Executor Framework

### Theory

Manages thread pools instead of manual thread creation.

### Example

```java
ExecutorService es = Executors.newFixedThreadPool(2);
es.execute(() -> System.out.println("Task"));
es.shutdown();
```

---

### Why preferred

* Thread reuse
* Better resource management
* Scalable

---

## 18. submit() vs execute()

| execute()     | submit()            |
| ------------- | ------------------- |
| No return     | Returns Future      |
| Runnable only | Runnable & Callable |

---

### Example

```java
Future<Integer> f = es.submit(() -> 10);
System.out.println(f.get());
```

---

## 19. Thread Safety in Concurrent Collections

### How Java ensures it

* Internal locking
* CAS (Compare-And-Swap)
* Fine-grained synchronization

### Examples

* ConcurrentHashMap
* CopyOnWriteArrayList

---

## 20. Fork/Join Framework

### Theory

Designed for divide-and-conquer parallelism.

### Example

```java
ForkJoinPool pool = new ForkJoinPool();
```

### Use cases

* Recursive tasks
* Parallel computation
* Large data processing

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
