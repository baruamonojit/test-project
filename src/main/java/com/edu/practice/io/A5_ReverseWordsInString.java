package com.edu.practice.io;

public class A5_ReverseWordsInString {

    private static String solution(String val) {
        if (val == null || val.isEmpty()) {
            return val;
        }
        String[] arr = val.split("\\s+");
        int left=0, right=arr.length-1;

        while (left<right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", arr);
    }
    private static String solution1(String str) {
        String[] arr = str.split("\\s+");
        int left=0, right=arr.length-1;
        while (left<right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", arr);
    }
    public static void main(String[] args) {
        String val = "This is monojit";
        System.out.println(solution1(val));
    }
}
