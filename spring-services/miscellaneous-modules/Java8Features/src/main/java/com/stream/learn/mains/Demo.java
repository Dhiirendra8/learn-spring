package com.stream.learn.mains;

import java.util.Comparator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Integer> nums = List.of(11,12,12,1,2,3,4,5,6,7,8,9);

        nums.stream().sorted(comparator).forEach(System.out::println);
    }

    private static Comparator<Integer> comparator = (a,b) -> a % 2 ==0?-1:1;
}
