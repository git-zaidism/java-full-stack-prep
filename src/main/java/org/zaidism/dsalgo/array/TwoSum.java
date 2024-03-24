package org.zaidism.practice.dsa.array;

// https://leetcode.com/problems/two-sum/

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
  public static void main(String[] args) {
    int[] sum = {3, 2, 4};
    int[] pair = twoSum(sum, 6);
    System.out.println(Arrays.toString(pair));
    // brute force
    System.out.println(Arrays.toString(twoSumBruteForce(sum, 6)));
  }

  static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> numsMap = new HashMap<>(nums.length);

    for (int i = 0; i < nums.length; i++) numsMap.put(nums[i], i);

    for (int i = 0; i < nums.length; i++) {
      int remainder = target - nums[i];

      if (numsMap.containsKey(remainder)) {
        int index = numsMap.get(remainder);

        if (i != index) return new int[] {i, index};
      }
    }
    return new int[] {-1, -1};
  }

  public static int[] twoSumBruteForce(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (target == nums[i] + nums[j])
          return new int[] {i, j};
      }
    }
    return new int[] {-1, -1};
  }
}
