package org.zaidism.practice.dsa.array;

// https://leetcode.com/problems/find-the-duplicate-number/description/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {
  public static void main(String[] args) {
    int[] nums = {3, 1, 4, 9};
    int[] duplicates = findUniqueElements(nums);
    Arrays.stream(duplicates).forEach(System.out::println);
    System.out.println(isDuplicate(arr));
  }

  static int[] findDuplicate(int[] nums) {
    return Arrays.stream(nums).distinct().sorted().toArray();
  }


  // interview test question
  public static int[] findUniqueElements(int[] arr) {
    if (arr.length == 0) return new int[] {-1};

    Set<Integer> uniqueSet = new HashSet<>();
    for (int num : arr) uniqueSet.add(num);

    if (uniqueSet.size() == arr.length) { // no duplicate present
      return new int[] {-1};
    } else {
      int[] uniqueElements = new int[uniqueSet.size()];
      int index = 0;
      for (int num : uniqueSet) {
        uniqueElements[index++] = num;
      }
      Arrays.sort(uniqueElements);
      return uniqueElements;
    }
  }

   private static int isDuplicate(int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int i : arr) {
            if (!numSet.contains(arr[i])) {
                numSet.add(i);
            } else {
                return i;
            }
        }
        return -1;
    }

     public static int findDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            if (!numSet.add(num)) {
                return num;
            } else {
                numSet.add(num);
            }
        }
        return -1;
    }
}

