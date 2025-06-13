package com.stream.learn.mains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondMin {
    public static void main(String[] args) {
        int [] arr = {1,3,4,5,7,6,7,98,87,65};
        System.out.println(secondMinFromArray(arr));
        List<Integer> list = List.of(1,3,5,7,9,8,6,4,2);
        int i = list.stream().sorted().skip(1).findFirst().orElse(0);
        System.out.println(i);
    }
    
    public static int secondMinFromArray(int[] arr){
        int i = Arrays.stream(arr).sorted().skip(1).findFirst().getAsInt();
        return i;
    }
}
