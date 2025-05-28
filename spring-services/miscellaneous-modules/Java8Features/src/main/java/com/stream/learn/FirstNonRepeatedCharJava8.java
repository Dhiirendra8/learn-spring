package com.stream.learn;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharJava8 {
    public static void main(String[] args) {
        String input = "dhirendra";
        Character result = findFirstNonRepeatedChar(input);

        if (result != null) {
            System.out.println("First non-repeated character: " + result);
        } else {
            System.out.println("No non-repeated character found.");
        }
    }

    public static Character findFirstNonRepeatedChar(String str) {
        return str.chars() // returns IntStream
                .mapToObj(c -> (char) c) // convert int to Character
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new, // preserve insertion order
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}

