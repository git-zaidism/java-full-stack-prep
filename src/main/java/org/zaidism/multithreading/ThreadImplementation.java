package org.zaidism.multithreading;

class ThroughRunnable implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 2; i++) {
      System.out.println(
          Thread.currentThread().getId() + " running inside ThroughRunnable class...");
    }
  }

}

class ThroughThread extends Thread {

  @Override
  public void run() {
    for (int j = 0; j < 2; j++) {
      System.out.println(Thread.currentThread().getId() + " running inside ThroughThread class...");
    }
  }

}

public class ThreadImplementation {

  public static void main(String[] args) {
    ThroughThread thread1 = new ThroughThread();
    thread1.start();

    ThroughRunnable throughRunnable = new ThroughRunnable();
    Thread thread2 = new Thread(throughRunnable);
    thread2.start();

    // Java 8 way
    Runnable runnable = () -> {
          for (int j = 0; j < 2; j++) {
            System.out.println(
                Thread.currentThread().getId() + " running using java 8 through runnable...");
          }
        };
    Thread thread3 = new Thread(runnable);
    thread3.start();

    Thread thread4 = new Thread(() -> {
              for (int j = 0; j < 2; j++) {
                System.out.println(
                    Thread.currentThread().getId()
                        + " running using java 8 through thread class...");
              }});

    thread4.start();
    // thread4.start(); if you execute more than one time you will get run time
    // IllegalThreadStateException
    // other thread and thread 4 might start executing but get run time exception when it reaches to
    // 2nd time
    // thread4.start();
    thread4.run(); // do nothing
  }
}
