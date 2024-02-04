package org.zaidism.exception;

public class ExceptionOrder {
  public static void main(String[] args) {
    try {
      System.out.println(10 / 0);
    } catch (ArithmeticException ae) { // add this after exception catch it will give compilation error as per hierarchy of exception class
      System.out.println(ae.getMessage());
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    } finally {
      System.out.println("finally");
    }
  }
}
