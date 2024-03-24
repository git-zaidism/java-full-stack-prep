package org.zaidism.practice.dsa.string;

public class StringIntern {
  public static void main(String[] args) {
    String name1 = "Jahid";
    String name2 = new String("Jahid");

    name2 = name2.intern();

    System.out.println(name1.equals(name2));
    System.out.println(name1 == name2);
  }
}
