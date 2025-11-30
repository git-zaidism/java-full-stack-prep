package org.zaidism.dsalgo.recusion;

//https://youtu.be/un6PLygfXrA?si=GqeMNszWrADGUmB8

public class RecursionAndBacktracking {

    public static void main(String[] args) {
        printName("Zahid", 5);
        print(1, 10);
        printReverseFrom(10);
        printWithoutPlus(10); //backtracking
        printWithoutMinusReverse(5, 10); //backtracking

    }

    private static void printReverseFrom(int i) {
        if (1 > i)
            return;
        System.out.print(i + " ");
        printReverseFrom(i - 1);
    }

    static void printName(String name, int count) {
        if (count == 0)
            return;
        System.out.print(name + " ");
        printName(name, count - 1);
    }

    static void print(int start, int end) {
        if (start == end) {
            System.out.println(start);
            return;
        }
        System.out.print(start + " ");
        print(start + 1, end);
    }

    static void printWithoutPlus(int end) {
        if (1 > end) return;
        printWithoutPlus(end - 1);
        System.out.print(end+ " ");
    }


    static void printWithoutMinusReverse(int start, int end) {
        if (end < start)
            return;
        printWithoutMinusReverse(start + 1, end);
        System.out.print(start+ " ");
    }
}
