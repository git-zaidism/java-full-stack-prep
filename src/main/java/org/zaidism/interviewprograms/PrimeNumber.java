package org.zaidism.interviewprograms;

// a number which has exactly two divisor 1 and itself are prime number
//sqrt 36 = 6
// 1 * 36 = 36
// 2 * 18 = 36
// 3 * 12 = 36
// 4 * 9 = 36
// 6 * 6 = 36
//=================== till here only we should check as rest of the below are same so sqrt of 36 = 6 we should check it through 6
// 9 * 4 = 36
// 12 * 3 = 36
// 18 * 2 = 36
// 36 * 1 = 36


public class PrimeNumber {
  public static void main(String[] args) {
    System.out.println(isPrime(1));
  }

  public static boolean isPrime(int num) { // log10(n) whenever these is division by 10 it will be log10 of n if divisible by 2 then log2(n) is complexity

    if (num <= 1) // 1 and less than 1 are not prime
     return false;

    for (int i = 2; i <= Math.sqrt(num); i++) { // divisible from 2 to square root of number
      if (num % i == 0) return false; // if divisible by any number then not prime
    }

    return true; // if not divisible by any number its prime
  }

  public static boolean isPrimeV2(int num) { //brute force O(n) complexity

    if (num <= 1) // 1 and less than 1 are not prime
     return false;

    for (int i = 2; i < num - 1; i++) {
      if (num % i == 0) return false;
    }

    return true;
  }
}
