package org.zaidism.functionalprogramming.functionalinterface;

import java.util.function.Function;

public class FunctionDemo {
  public static void main(String[] args) {
    Function<String, Integer> lengthOfStr = String::length;
    System.out.println(lengthOfStr.apply("Jahid"));

    Function<String, String> substringFunction = s -> s.substring(0, 3);
    System.out.println(substringFunction.apply("Jahid"));

    Function<String, String> upperCaseFunction = s -> s.toUpperCase();

    // and then method
    Function<String, String> doubleOperationFunction = upperCaseFunction.andThen(substringFunction);
    System.out.println(doubleOperationFunction.apply("Jahid"));
    // another way of doing samething
    System.out.println(upperCaseFunction.andThen(substringFunction).apply("Amina"));
  }
}
