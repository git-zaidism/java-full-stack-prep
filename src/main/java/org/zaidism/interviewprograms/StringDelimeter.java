package org.zaidism.interviewprograms;

// input : jahid
// output:
// j ahid
// ja hid
// jah id
// jahi d

public class StringDelimeter {
  public static void main(String[] args) {
    String input = "jahid";

    for (int i = 1; i < input.length(); i++) {
      StringBuilder output = new StringBuilder(input);
      output.insert(i, ' ');
      System.out.println(output);
    }
    System.out.println("-------------------------------------------------------------------------");

    // another way
    for (int i = 0; i <= input.length() - 1; i++) {
      if (i != 0)
        System.out.println(input.substring(0, i) + " " + input.substring(i, input.length()));
    }
  }
}
