package com.edu.practice.io;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class A12_DuplicateWithIndicesDiff {

    private static boolean solution(int[] nums, int k) {
        Map<Integer,Integer> dup = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (dup.containsKey(nums[i]) && (i - dup.get(nums[i])) <=k ){
                return true;
            }
            dup.put(nums[i],i);
        }
        return false;
    }

    private static boolean solution1(int[] nums, int k) {

        HashMap<Integer, Integer> dup = new HashMap<>();

        for (int i=0; i<nums.length; i++) {

            if (dup.containsKey(nums[i]) &&
                    (i-dup.get(nums[i]))<=k ) {
                return true;
            }
            dup.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{7,8,6,7,9};
        int k = 5;
        System.out.println(solution(arr,k));
        System.out.println(solution1(arr,k));
    }
}
