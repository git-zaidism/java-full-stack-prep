package org.zaidism.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
  private static final AtomicInteger counter = new AtomicInteger(0);

  public static void main(String[] args) {
    Thread thread1 =
        new Thread(
            () -> {
              for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
              }
            });

    Thread thread2 =
        new Thread(
            () -> {
              for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
              }
            });

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Final Counter Value: " + counter.get());
  }
}
