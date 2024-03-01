package org.zaidism.interviewprograms;

public class ReverseNumber {

  public static void main(String[] args) {
    int num = 2356;
    int reversedNum = reverseNumber(num);
    System.out.println(num + " revered to " + reversedNum);

    // another way
    String n = Integer.toString(num);
    System.out.println(Integer.parseInt(new StringBuilder(n).reverse().toString()));
  }

  private static int reverseNumber(int num) {
    int reversedNumber = 0;

    while (num > 0) {
      int lastDigit = num % 10;
      reversedNumber = reversedNumber * 10 + lastDigit;
      num = num / 10;
    }
    return reversedNumber;
  }
}
