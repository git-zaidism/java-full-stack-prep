package org.zaidism.interviewprograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// THG asked this question
// ignore count of alphabets and ignore case
// order of input can interchange with each other like (str1, str2) (str2, str1)
public class HasSameAlphabets {
  public static void main(String[] args) {
    String str1 = "states";
    String str2 = "taste";
    String str3 = "states";
    String str4 = "tasty";

    boolean containsSameLetter1 = hasSameLetterV2(str1, str2);
    System.out.println(containsSameLetter1); // Should print true
    boolean containsSameLetter2 = hasSameLetterV2(str3, str4);
    System.out.println(containsSameLetter2); // Should print false
  }

  private static boolean hasSameLetter(String str1, String str2) {
    Set<Character> characterSetStr1 = new HashSet<>();
    Set<Character> characterSetStr2 = new HashSet<>();

      for (Character c : str1.toCharArray()) {
      if (Character.isLetter(c)) // optional to check
         characterSetStr1.add(c);
    }

    for (Character c : str2.toCharArray()) {
      if (Character.isLetter(c)) // optional to check
        characterSetStr2.add(c);
    }

    return characterSetStr1.equals(characterSetStr2);
  }

    private static boolean hasSameLetterV2(String str1, String str2) {
        Set<String> stringSet1 = Arrays.stream(str1.split("")).collect(Collectors.toSet());
        Set<String> stringSet2 = Arrays.stream(str2.split("")).collect(Collectors.toSet());
        return stringSet1.equals(stringSet2);
    }
}
