package org.zaidism.dsalgo.recusion;

public class ProdOfDigit {
    public static void main(String[] args) {
        System.out.println(getProdOfDigit(523));
    }

    private static int getProdOfDigit(int n) {
        if (n == 0)
            return 1;

        return n % 10 * getProdOfDigit(n / 10);
    }
}
