package org.zaidism.multithreading;

public class InterThreadCommunication {
  int totalEarning = 0;

  public void calculateEarning() {
    synchronized (this) {
      for (int i = 0; i < 10; i++) {
        totalEarning = totalEarning + 100;
      }
      this.notify();
    }
  }

  public static void main(String[] args) throws InterruptedException {

    InterThreadCommunication interThreadCommunication = new InterThreadCommunication();

    Thread thread1 =
        new Thread(
            () -> {
              interThreadCommunication.calculateEarning();
            },
            "Thread 1");

    thread1.start();

    synchronized (interThreadCommunication) {
      interThreadCommunication.wait();
    }

    System.out.println("Total Earnings : " + interThreadCommunication.totalEarning);
  }
}
