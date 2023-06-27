package com.stream.learn.mains;

import com.stream.learn.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StreamReduceMethod {
    public static void main(String[] args) {
        List<Student> lists = new ArrayList<Student>();
        Student st1 = new Student(1, "Student1", 21,"abc1@gmail.com");
        Student st2 = new Student(2, "Student1", 22,"abc2@gmail.com");
        Student st3 = new Student(3, "Student1", 23,"abc3@gmail.com");
        Student st4 = new Student(4, "Student1", 24,"abc4@gmail.com");
        Student st5 = new Student(5, "Student1", 25,"abc5@gmail.com");

        Student st6 = st4;
        Student st7 = st5;

        lists.add(st1);
        lists.add(st2);
        lists.add(st3);
        lists.add(st4);
        lists.add(st5);
        lists.add(st6);
        lists.add(st7);

//        lists.stream().reduce();
    }
}
