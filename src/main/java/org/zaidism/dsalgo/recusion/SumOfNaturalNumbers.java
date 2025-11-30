package org.zaidism.dsalgo.recusion;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        getSumFirstNNumbers(3, 0);
        System.out.println(getSumFirstNNumbers(3));
    }

    private static void getSumFirstNNumbers(int n, int sum) {
        if (n < 1) {
            System.out.println(sum);
            return;
        }
        getSumFirstNNumbers(n - 1, sum + n);
    }

    private static int getSumFirstNNumbers(int n) {  //easy
        if (n == 1) {
            return 1;
        }
        return n + getSumFirstNNumbers(n - 1);
    }
}
