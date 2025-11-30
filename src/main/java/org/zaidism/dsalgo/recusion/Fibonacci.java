package org.zaidism.dsalgo.recusion;

public class Fibonacci // multiple function call
{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.print(fibonacci(i) + " ");

        System.out.println();

        // nth fibonacci number
        System.out.println(fibonacci(6));
    }

    static int fibonacci(int n) {
        // Base cases: The 0th Fibonacci number is 0. The 1st Fibonacci number is 1.
        if (n < 2)
            return n;
        // Recursive case: The n -th Fibonacci number is the sum of the (n-1)-th and (n-2)-th Fibonacci numbers.
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
