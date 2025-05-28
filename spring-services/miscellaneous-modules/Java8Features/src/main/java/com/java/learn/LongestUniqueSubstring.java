package com.java.learn;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

    public static String getLongestUniqueSubstring(String input) {
        if (input == null || input.isEmpty()) return "";

        Map<Character, Integer> indexMap = new HashMap<>();
        int start = 0, maxLen = 0, maxStart = 0;

        for (int end = 0; end < input.length(); end++) {
            char currentChar = input.charAt(end);

            if (indexMap.containsKey(currentChar) && indexMap.get(currentChar) >= start) {
                start = indexMap.get(currentChar) + 1;
            }

            indexMap.put(currentChar, end);

            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                maxStart = start;
            }
        }

        System.out.println("Map:: "+indexMap);

        return input.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String[] args) {
        String input = "abcabcdb";
        String result = getLongestUniqueSubstring(input);
        System.out.println("Longest non-repeating substring: " + result);
    }
}

