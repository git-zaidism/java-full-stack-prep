package org.zaidism.functionalprogramming.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperator {
  public static void main(String[] args) {
    // input type and output type is same in both the below cases
    Function<String, String> stringFunction = s -> s.toLowerCase();
    System.out.println(stringFunction.apply("AMINA"));

    BiFunction<Integer, Integer, Integer> integerBiFunction = (a, b) -> a + b * a + b;
    System.out.println(integerBiFunction.apply(1, 2));

    // these are used insteead of funtion and bi function when input and output type are same
    UnaryOperator<String> unaryOperator = s -> s.toLowerCase();
    BinaryOperator<Integer> binaryOperator = (a, b) -> a + b * a + b;
    System.out.println(unaryOperator.apply("Zahid"));
    System.out.println(binaryOperator.apply(2, 3));
  }
}
