package com.stream.learn;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortByFrequency {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,1,4,4,2,4,6,4,3,5,3,3,5,7,6,9,1,2,3,1,2,3,7,8,7);

        // Step 1: Count the frequency of each number
        Map<Integer, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Step 2: Sort the list based on frequency, then by value
        List<Integer> sortedList = list.stream()
                .sorted(Comparator
                        .comparing((Integer n) -> frequencyMap.get(n))  // by frequency
                        .thenComparing(Function.identity()))                     // then by natural order
                .toList();

        System.out.println("Sorted by frequency and value: " + sortedList);
    }
}
