package org.zaidism.interviewprograms;

// Given an array of N integers, and an integer K, the task is to find the number of pairs of
// integers in the array whose sum is equal to K.
// Input: arr[] = {1, 5, 7, -1, 5, 1, 2, 4} K = 6

// Given an array of integers nums and an integer target, return indices of the two numbers such
// that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same
// element twice.
// You can return the answer in any order.
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Input: nums = [3,3], target = 6
// Output: [0,1]
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
    int[] sum = {3, 2, 4};
    int[] pair = twoSum(sum, 6);
    System.out.println(Arrays.toString(pair));
  }

  static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) numsMap.put(nums[i], i);

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int remainder = target - num;

      if (numsMap.containsKey(remainder)) {

        int index = numsMap.get(remainder);

        if (index == i) continue;

        return new int[] {i, index};
      }
    }
    return new int[] {-1, -1};
  }
}
