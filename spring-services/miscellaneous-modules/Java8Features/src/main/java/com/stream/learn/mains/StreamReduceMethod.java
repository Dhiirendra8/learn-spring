package com.stream.learn.mains;

import com.stream.learn.model.Student;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamReduceMethod {
    public static void main(String[] args) {
//        program1();
        program2();
    }
    public static void program1(){
        List<Student> lists = new ArrayList<Student>();
        Student st1 = new Student(1, "Student1", 21,"abc1@gmail.com");
        Student st2 = new Student(2, "Student2", 22,"abc2@gmail.com");
        Student st3 = new Student(3, "Student3", 23,"abc3@gmail.com");
        Student st4 = new Student(4, "Student4", 24,"abc4@gmail.com");
        Student st5 = new Student(5, "Student5", 25,"abc5@gmail.com");

        Student st6 = st4;
        Student st7 = st5;

        lists.add(st1);
        lists.add(st2);
        lists.add(st3);
        lists.add(st4);
        lists.add(st5);
        lists.add(st6);
        lists.add(st7);

        Student student = lists.stream().reduce(st1, BinaryOperator.maxBy(Comparator.comparingInt(Student::getAge)));
        Student student1 = lists.stream().reduce(st1, BinaryOperator.minBy(Comparator.comparing(Student::getAge)));
        System.out.println(student);
        System.out.println(student1);

    }

    public static void program2(){

//        List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
//                Lists.newArrayList("Mariam", "Alex", "Ismail"),
//                Lists.newArrayList("John", "Alesha", "Andre"),
//                Lists.newArrayList("Susy", "Ali")
//        );
        List<List<String>> arrayListOfNames = List.of(
                List.of("Mariam", "Alex", "Ismail"),
                List.of("John", "Alesha", "Andre"),
                List.of("John", "Alesha", "Andre")
        );
//        List<String> o = new ArrayList<>();
        List<String> o =arrayListOfNames.stream().reduce(List.of(), (a,b) -> Stream.concat(a.stream(),b.stream()).toList());
        System.out.println(o);
        List<String> o2 =arrayListOfNames.stream().flatMap(List::stream).toList();
        System.out.println(o2);
        List<String> o3 =arrayListOfNames.stream().flatMap(List::stream).sorted().toList();
        System.out.println(o3);
        List<String> o4 =arrayListOfNames.stream().flatMap(List::stream).sorted(Comparator.reverseOrder()).toList();
        System.out.println(o4);
        List<String> o5 =arrayListOfNames.stream().flatMap(List::stream).sorted(Collections.reverseOrder()).toList();
        List<String> o6 =arrayListOfNames.stream().flatMap(List::stream).sorted((l1,l2)-> l2.compareTo(l1)).toList();
        System.out.println(o5);
        System.out.println(o6);
    }
}
