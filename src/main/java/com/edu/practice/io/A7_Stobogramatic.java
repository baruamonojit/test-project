package com.edu.practice.io;

import java.util.HashMap;

public class A7_Stobogramatic {

        private static boolean solution(String num) {
            HashMap<Character, Character> map = new HashMap<>();
            map.put('6','9');
            map.put('9','6');
            map.put('1','1');
            map.put('8','8');
            map.put('0','0');

            char[] nums = num.toCharArray();
            int left =0, right= nums.length-1;
            while (left<=right) {
                if (!map.containsKey(num.charAt(right)) ||
                        num.charAt(left) != map.get(num.charAt(right)) ) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        private static boolean solution1(String num) {
            HashMap<Character, Character> map = new HashMap<>();
            map.put('1','1');
            map.put('6','9');
            map.put('8','8');
            map.put('9','6');
            map.put('0','0');

            char[] arr = num.toCharArray();
            int left=0, right = arr.length-1;
            while (left<right) {

                if (!map.containsKey(arr[left])
                        || map.get(arr[left]) != arr[right] ) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    public static void main(String[] args) {
        System.out.println(solution1("808"));
    }
}
