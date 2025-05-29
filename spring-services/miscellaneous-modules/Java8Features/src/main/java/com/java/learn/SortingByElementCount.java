package com.java.learn;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingByElementCount {


    public static void main(String[] args) {

        Comparator<Map.Entry<Integer,Long>> comparator = (a, b) -> {
            int i = Integer.parseInt(a.getValue()+"");
            int j = Integer.parseInt(b.getValue()+"");
            if(i == j){
                return Integer.parseInt(a.getKey()+"") - Integer.parseInt(b.getKey()+"");
            }
            return i-j;
        };
        List<Integer> list = List.of(1,1,4,4,4,6,4,3,5,3,3,5,7,6,9,1,2,3,1,2,3,7,8,7);

        Map<Integer,Long> map = list.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new,Collectors.counting())
                );
        System.out.println(map);

        List<Integer> sortedList = map.entrySet().stream()
//                .sorted((a,b)->(Integer)a.getKey() - Integer.parseInt(b.getValue()+""))
                .sorted(comparator)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        List<Integer> listOut = new LinkedList<>();
        for(Integer i :sortedList){
            int len=Integer.parseInt(map.get(i).toString());
            for(int j=1;j<=len;j++){
                listOut.add(i);
            }
        }


        System.out.println(sortedList);
        System.out.println(listOut);

    }
}
