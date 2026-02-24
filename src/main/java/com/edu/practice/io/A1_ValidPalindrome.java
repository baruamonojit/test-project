package com.edu.practice.io;

public class A1_ValidPalindrome {
    
    private static boolean solution(String val) {

        if (null==val || val.isEmpty()) {
            return false;
        }

        int  left=0, right=val.length()-1;
        while (left<right) {
            if (!Character.isLetter(val.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetter(val.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(val.charAt(left))!=Character.toLowerCase(val.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String val = "Madam, in Eden, Im Adam2";
        System.out.println(val + " - " +solution(val));
    }
}
