package org.zaidism.multithreading;

public class DaemonThreadExample {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon Thread is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Set the thread as a daemon thread
        daemonThread.setDaemon(true);

        // Start the daemon thread
        daemonThread.start();

        // Main thread
        System.out.println("Main Thread exiting");
    }
}
