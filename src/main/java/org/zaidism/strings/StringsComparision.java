package org.zaidism.strings;

public class StringsComparision {
    public static void main(String[] args) throws InterruptedException {
        // StringBuffer is thread-safe (synchronized internally)
        StringBuffer buf = new StringBuffer(); // change this to StringBuilder will give us unpredictable output
        Runnable task = () -> {
            for (int i = 0; i < 500_000; i++) {
                buf.append("x"); // safe due to internal synchronization
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Length with StringBuffer (should be 1,000,000): " + buf.length());

        // StringBuilder is NOT thread-safe — safe to use in single-threaded context
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("x");
        }
        System.out.println("StringBuilder result: " + sb);

        // Plain string concatenation inside a loop — very inefficient
        String s = "";
        for (int i = 0; i < 1000; i++) {
            s += "x"; // creates a new String each time (not memory efficient)
        }
        System.out.println("String result: " + s);
    }
}
