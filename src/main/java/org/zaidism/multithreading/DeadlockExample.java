package org.zaidism.multithreading;

public class DeadlockExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();


    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 acquired lock1!");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Acquire lock2 before releasing lock1
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired lock2!");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {  // Acquire lock2 first
                System.out.println("Thread 2 acquired lock2!");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Acquire lock1 before releasing lock2
                synchronized (lock1) {
                    System.out.println("Thread 2 acquired lock1!");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
