package com.edu.practice.io;

import java.util.HashSet;
import java.util.Set;

public class A11_LongestSubstring {

    private static int solutions(String s) {
        Set<Character> dup = new HashSet<>();
        int left =0, right=0, max=0;

        for (right=0;right<s.length();right++) {
            while (dup.contains(s.charAt(right))) {
                dup.remove(s.charAt(left));
                left++;
            }
            dup.add(s.charAt(right));
            max = Math.max(max,(right-left)+1);
        }
        return max;
    }

    private static String solutions1(String s) {
        int left =0, max = 0, start = 0;
        HashSet<Character> dupChecker = new HashSet<>();
        for (int right=0; right<s.length(); right++) {
            while (dupChecker.contains(s.charAt(right))) {
                dupChecker.remove(s.charAt(left));
                left++;
            }
            dupChecker.add(s.charAt(right));
            if (right-left+1> max) {
                max = right-left+1;
                start = left;
            }
        }
        return s.substring(start, start+max);
    }

    public static void main(String[] args) {
        System.out.println(solutions("hrrmimppk"));
        System.out.println(solutions1("hrrmimppk"));
    }
}
