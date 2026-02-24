package com.edu.practice.io;

import java.util.Arrays;

public class A4_SortColor {

    private static void solution(int[] colors) {
        if (colors==null || colors.length==0) {
            return;
        }
        int left = 0, right = colors.length-1;
        for (int i=0; i<=right;) {
            if (colors[i]==0) {
                swap(colors, i, left);
                left++;
                i++;
            } else if (colors[i]==1) {
                i++;
            } else if (colors[i]==2) {
                swap(colors, i, right);
                right--;
            }
        }
    }

    private static void solution1(int [] arr ) {

        if (arr == null || arr.length==0) {
            return;
        }
        int left =0, right = arr.length-1;
        for (int i=0; i<= right;) {
            if (arr[i] == 0) {
                swap(arr, i, left);
                left++;
                i++;
            } else if (arr[i]==1) {
                i++;
            } else if (arr[i]==2) {
                swap(arr, i, right);
                right--;
            }
        }
    }

    private static void swap(int[] colors, int pos1, int pos2) {
        int temp = colors[pos1];
        colors[pos1] = colors[pos2];
        colors[pos2] = temp;
    }

    public static void main(String[] args) {
       // int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums = {2,1,1,0,0};
        System.out.println("Before Sorting: " + Arrays.toString(nums));
        solution1(nums);
        System.out.println("After Sorting:  " + Arrays.toString(nums));
    }
}
