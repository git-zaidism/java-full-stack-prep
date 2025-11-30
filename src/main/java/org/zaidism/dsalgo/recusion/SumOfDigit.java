package org.zaidism.dsalgo.recusion;

public class SumOfDigit {
    public static void main(String[] args) {
        System.out.println(getSumOfDigit(1245));
    }

    private static int getSumOfDigit(int n) {
        if (n == 0)
            return n;

        return n % 10 + getSumOfDigit(n / 10);
    }
}
