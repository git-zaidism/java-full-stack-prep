package org.zaidism.dsalgo.array;

//https://leetcode.com/problems/move-zeroes/
//using two pointer approach

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums [i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
