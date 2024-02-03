package org.zaidism.functionalprogramming;

public class MethodReference {
  public static void main(String[] args) {

    Functional functional = AgeCalculator::ageAbove18;
    System.out.println(functional.checkAge(18));
  }
}

interface Functional {
    boolean checkAge(int age);
}

class AgeCalculator {

  static boolean ageAbove18(int age) {
    return age >= 18;
  }
}
