package org.zaidism.interviewprograms;

public class ReverseString {

  public static void main(String[] args) {
    String name = "Jahid";
    printReverseOfString(name);
  }

  static void printReverseOfString(String name) {
    char[] charArray = name.toCharArray();
    String output = "";
    for (int i = charArray.length - 1; i >= 0; i--)
        output += charArray[i];

    System.out.println(output);

    // another way
    StringBuilder str2 = new StringBuilder(name).reverse();
    System.out.println(str2);
  }
}
