package com.edu.practice.io;

public class L3_ContainerWithMostWater {

    private static int solution (int[] arr) {
        int left =0, right = arr.length-1;
        int max = 0;
        while (left < right) {
            int width = right - left;
            int height = Math.min(arr[left], arr[right]);
            if (arr[right] > arr[left]) {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, (height*width));
        }
        return max;
    }

    public static void main(String[] args) {

        int[] heights = {1,8,6,2,5,4,8,3,7};
        int result = solution(heights);
        System.out.println("Maximum Water: " + result);
    }
}
