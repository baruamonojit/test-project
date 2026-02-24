package com.edu.practice.io;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class A9_CountPairsLessThanTarget {

    private static int solutions(List<Integer> nums, int target) {
        int count =0, left=0, right=nums.size()-1;
        Collections.sort(nums);
        while (left<right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum<target) {
                count = count + (right-left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    private static int solutions1(List<Integer> arr, int target) {

        if (arr == null || arr.isEmpty()) {
            return -1;
        }

        Collections.sort(arr);
        int left = 0, right = arr.size()-1, count=0;
        while (left< right) {
            int sum = arr.get(left) + arr.get(right);
            if (sum<target) {
                count = count + (right-left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Integer[] nums = {22, 1, 5, 3, 7};
        int target = 10;

        int result = solutions(Arrays.asList(nums), target);
        int result1 = solutions1(Arrays.asList(nums), target);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Number of pairs whose sum is less than target: " + result);
        System.out.println("Number of pairs whose sum is less than target1: " + result1);
    }
}
