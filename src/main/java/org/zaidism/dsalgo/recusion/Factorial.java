package org.zaidism.dsalgo.recusion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(getFactorial(5));
    }

    private static int getFactorial(int n) {
        if (n == 1) return n;
        return n * getFactorial(n - 1);
    }
}
