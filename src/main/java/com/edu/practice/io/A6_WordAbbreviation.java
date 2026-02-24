package com.edu.practice.io;

public class A6_WordAbbreviation {

    private static boolean solution(String word, String abbr) {
        int wordPointer=0, abbrPointer=0;
        while (abbrPointer<abbr.length()) {
            if ( wordPointer>word.length()) {
                return false;
            }

            if (Character.isLetter(abbr.charAt(abbrPointer))) {
                if (Character.toLowerCase(word.charAt(wordPointer)) != Character.toLowerCase(abbr.charAt(abbrPointer)) )  {
                    return false;
                }
                abbrPointer++;
                wordPointer++;
            } else if (Character.isDigit(abbr.charAt(abbrPointer))) {
                if (abbr.charAt(abbrPointer) == '0') {
                    return false;
                }
                int counter = 0;
                while (Character.isDigit(abbr.charAt(abbrPointer)) && abbrPointer<abbr.length()) {
                    counter = counter*10 + (abbr.charAt(abbrPointer) - '0');
                    abbrPointer++;
                }
                wordPointer = wordPointer + counter;
            }

        }

        return word.length()==wordPointer;
    }



    private static boolean solution1(String word, String abbr) {
        int wordPointer = 0, abbrPointer =0;
        while (abbrPointer < abbr.length()) {
            if (wordPointer>word.length()) {
                return false;
            }
            if (Character.isLetter(abbr.charAt(abbrPointer) )) {
                if (Character.toLowerCase(abbr.charAt(abbrPointer)) != Character.toLowerCase(word.charAt(wordPointer))) {
                    return false;
                }
                wordPointer++;
                abbrPointer++;
            } else if (Character.isDigit(abbr.charAt(abbrPointer))) {
                if (abbr.charAt(abbrPointer) == '0') {
                    return false;
                }
                int count = 0;
                while (Character.isDigit(abbr.charAt(abbrPointer)) && abbrPointer<abbr.length()) {
                    count = count*10 + (abbr.charAt(abbrPointer)-'0');
                    abbrPointer++;
                }
                wordPointer = wordPointer + count;
            }
        }
        return wordPointer == word.length();
    }
    public static void main(String[] args) {
        System.out.println(solution1("internationalization", "13iz4n"));
        System.out.println(solution1("computation", "compu03on"));
    }
}
