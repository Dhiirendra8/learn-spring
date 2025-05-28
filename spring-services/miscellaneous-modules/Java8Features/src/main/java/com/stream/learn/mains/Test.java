package com.stream.learn.mains;

import com.stream.learn.interfaces.InterF;

import java.util.*;
import java.util.stream.Stream;

public class Test {
    int x=10;

    public void m2(){
        InterF i1 = new InterF() {
            int x=20;
            @Override
            public void m1() {
                System.out.println("value of x: "+this.x);
                System.out.println("value of x: "+Test.this.x);
            }
        };
        i1.m1();
    }
    public static void main(String[] args) {
//        System.err.println("### main starts from here ... ###");
//        Test t = new Test();
//        t.m2();// check line 13,14

        int[] arr = {4,6,8,4,4,2,9,8,2};
        //print unique only
        Map<Integer,Integer> m = new HashMap<>();
        for (int i: arr){
            if(m.containsKey(i)){
                int val = m.get(i);
                m.put(i,val+1);
            }else {
                m.put(i,1);
            }
        }
        System.out.println(m);
        List<Integer> l = new ArrayList<>();
        for (Map.Entry e:m.entrySet()){
            if((int)e.getValue()==1){
                l.add((int)e.getKey());
            }
        }
        System.out.println(l);
        int[] streamArr = Arrays.stream(arr).distinct().toArray();
//        Arrays.stream(streamArr).forEach(System.out::println);


        StringBuffer sb = new StringBuffer();
        sb.append("A");
        sb.append("B");
        sb.append("A");
        sb.append("C");
        sb.append("A");
        sb.append("D");
        System.out.println(sb.toString());

    }
}
