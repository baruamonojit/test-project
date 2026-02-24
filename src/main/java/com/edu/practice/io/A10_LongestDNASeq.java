package com.edu.practice.io;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class A10_LongestDNASeq {

    private static List<String> solutions(String s) {
        HashSet<String> dupChecker = new HashSet<>();
        HashSet<String> finalList = new HashSet<>();

        for (int i=0;i+10<s.length();i++) {
             if (!dupChecker.add(s.substring(i,i+10))) {
                 finalList.add(s.substring(i,i+10));
             }
        }
        return new ArrayList<>(finalList);
    }

    private static ArrayList<String> solution1 (String s) {
        HashSet<String> dupChecker = new HashSet<>();
        ArrayList<String> finalList = new ArrayList<>();
        for (int i=0; i+10<s.length(); i++) {
            String strToCheck = s.substring(i,i+10);
            if (!dupChecker.add(strToCheck)) {
                finalList.add(strToCheck);
            }
        }
        return finalList;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(solutions(s));
        System.out.println(solution1(s));
    }
}
