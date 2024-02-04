package org.zaidism.exception;

public class ExceptionInterviewQuestion {
  public static void main(String[] args) {
    System.out.println(getValue());
  }

  private static int getValue() {
    try {
      System.out.println("Inside try");
      throw new RuntimeException();
    } catch (Exception e) {
      System.out.println("Inside catch");
      return 10;
    } finally {
      System.out.println("Inside finally");
      return 20;
    }
  }
}
