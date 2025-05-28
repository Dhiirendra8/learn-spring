package com.java.learn;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {

    private static Comparator<String> comparator = (a,b) -> (a==null || b==null)? -1:a.compareTo(b);
    public static void main(String[] args) {
        Set<String> set = new TreeSet(comparator);
//        set.add(null);
        set.add("abc");
        set.add("xyz");
        set.add(null);
        set.add("lll");
        set.add(null);

        System.out.println(set);
    }
}
