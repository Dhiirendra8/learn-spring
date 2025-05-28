package com.stream.learn.mains;

import com.stream.learn.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {

    List<Student> lists = new ArrayList<Student>();
    Student st1 = new Student(1, "Student1", 21,"abc1@gmail.com");
    Student st2 = new Student(2, "Student1", 22,"abc2@gmail.com");
    Student st3 = new Student(3, "Student1", 23,"abc3@gmail.com");
    Student st4 = new Student(4, "Student1", 24,"abc4@gmail.com");
    Student st5 = new Student(5, "Student1", 25,"abc5@gmail.com");
    lists.add(st1);
    lists.add(st2);
    lists.add(st3);
    lists.add(st4);
    lists.add(st5);

    List<Student> rList = lists.stream().filter(s -> s.getAge() > 22).toList();

    for(Student s : rList){
        System.out.println(s.toString());
    }
    String str = "Springboot".toLowerCase().trim();

    char [] chars = str.toCharArray();

    Map<Character, Integer> map = new HashMap<>();

    int i=0;
    for(char c: chars){
        if(map.containsKey(c)){
           map.remove(c);
        }else{
            map.put(c,1);
        }


    }

    System.out.println(map);
//        Optional<String> st;
//        Throwable;
        for(char c: chars){
            if(map.containsKey(c)){
                System.out.println(c);

                break;
            }
        }
    }


    //


}
