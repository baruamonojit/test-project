package com.edu.practice.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class A2_ThreeSum {

    private static List<List<Integer>> solution(int[] arr) {

        if (arr ==null || arr.length<3){
            return null;
        }
        Arrays.sort(arr);
        HashSet<List<Integer>> finalResult = new HashSet<>();
        for (int i=0;i<arr.length-2;i++) {
            int left = i+1, right = arr.length-1;
            while (left<right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum==0) {
                    finalResult.add(Arrays.asList(arr[i] , arr[left] , arr[right]));
                    left++;
                    right--;
                } else if (sum<0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(finalResult);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-3, 0, 1, 2, -1, -4};
        System.out.println(solution(arr));
    }
}
