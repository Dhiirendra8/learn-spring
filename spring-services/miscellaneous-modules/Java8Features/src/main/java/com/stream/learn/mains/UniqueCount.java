package com.stream.learn.mains;

public class UniqueCount {
    public static void main(String[] args) {
        int[] arr = {1,2,1,5,5,6,2};
        int x =0;
        for(int i: arr){
            x = x ^ i;
        }
        System.out.println(x);
    }
}
