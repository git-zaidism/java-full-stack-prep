package org.zaidism.functionalprogramming.functionalinterface.lambda;

@FunctionalInterface
interface FunInterface {

    int getSquare(int num);

    default String getStrInLowerCase(String str) {
        return str.toLowerCase();
    }
}

public class LambdaDemo {
    public static void main(String[] args) {
        FunInterface square = (num) -> {
            if (num != 0)
                return num * num;
            else return -1;
        };

        System.out.println(square.getSquare(10));
    }

}
