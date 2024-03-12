package org.zaidism.functionalprogramming.functionalinterface;

import java.util.function.Supplier;

public class SupplierDemo {
  public static void main(String[] args) {

    Supplier<String> getUrl = () -> "https://www.java.com";
    System.out.println(getUrl.get());

    Supplier<Float> getPiValue = () -> 3.142f;
    System.out.println(getPiValue.get());
  }
}
