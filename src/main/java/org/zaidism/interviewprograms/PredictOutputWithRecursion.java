package org.zaidism.interviewprograms;


public class PredictOutputWithRecursion {
  public static void main(String[] args) {
    foo(1234);
  }

  public static void foo(int a) {

    System.out.print(a % 10);
    if (a % 10 != 0) {
      foo(a / 10);
    }
    System.out.print(a % 10);
  }
}
