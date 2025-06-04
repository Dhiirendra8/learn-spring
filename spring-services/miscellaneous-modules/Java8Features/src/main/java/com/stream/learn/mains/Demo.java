package com.stream.learn.mains;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
//        List<Integer> nums = List.of(11,12,12,1,2,3,4,5,6,7,8,9);
//
//        nums.stream().sorted(comparator).forEach(System.out::println);

        String name = "dhirendra";
        List<Character> chars =
        name.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        String joinStr = chars.parallelStream().map(c -> c.toString().toUpperCase()).collect(Collectors.joining(""));

        System.out.println(joinStr);

        Integer number = 4;
        Stream<Integer> result = Stream.ofNullable(number);
        result.map(x -> x * x).forEach(System.out::println);

    }

    private static Comparator<Integer> comparator = (a,b) -> a % 2 ==0?-1:1;
}
