package org.zaidism.interviewprograms;

public class PalindromeString {
  public static void main(String[] args) {
    String str = "raceCar";
    System.out.println(checkPalindrome(str));
    System.out.println(checkPalindromeV2(str));
  }

  private static boolean checkPalindrome(String str) {
    str = str.toLowerCase();
    boolean isPalindrome = true;
    int start = 0;
    int end = str.length() - 1;

    while (start <= end) {
      if (str.charAt(start) != str.charAt(end)) {
        isPalindrome = false;
        break;
      }
      start++;
      end--;
    }
    return isPalindrome;
  }

  private static boolean checkPalindromeV2(String input) {
    String str = input.toLowerCase();
    StringBuilder sb = new StringBuilder(str).reverse();
    return sb.toString().toLowerCase().equals(str);
  }
}
