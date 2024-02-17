package org.zaidism.practice.dsa.array;

// https://leetcode.com/problems/find-the-duplicate-number/description/

import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {
  public static void main(String[] args) {
    int[] nums = {3, 1, 3, 4, 2};
    int duplicateNum = findDuplicate(nums);
    System.out.println(duplicateNum);
  }

  static int findDuplicate(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int i : nums) {
      if (!numSet.contains(i)) numSet.add(i);
      else return i;
    }
    return -1;
  }
}
