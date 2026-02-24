package com.edu.practice.io;

public class A14_FindDuplicateNumber {
    //Floyd's Cycle Detection Algorithm

    private static int solution(int[] arr) {

        int slow=0, fast=0;

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while (slow !=fast);
        slow = 0;

        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate in nums: " + solution(nums2));
    }
}
