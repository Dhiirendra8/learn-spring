package com.stream.learn.data;

import java.util.ArrayList;
import java.util.List;

import com.stream.learn.model.Employee;
import com.stream.learn.model.Student;

public class StaticData {
	
	public static List<Student>  getStudents(){
		List<Student> lists = new ArrayList<Student>();
	    Student st1 = new Student(1, "Student1", 21,"abc1@gmail.com");
	    Student st2 = new Student(2, "Student1", 22,"abc2@gmail.com");
	    Student st3 = new Student(3, "Student1", 23,"abc3@gmail.com");
	    Student st4 = new Student(4, "Student1", 24,"abc4@gmail.com");
	    Student st5 = new Student(5, "Student1", 25,"abc5@gmail.com");
	    Student st6 = new Student(6, "Student2", 21,"abc1@gmail.com");
	    Student st7 = new Student(7, "Student2", 22,"abc2@gmail.com");
	    Student st8 = new Student(8, "Student3", 23,"abc3@gmail.com");
	    Student st9 = new Student(9, "Student3", 24,"abc4@gmail.com");
	    Student st10 = new Student(5, "Student4", 25,"abc5@gmail.com");
	    lists.add(st1);
	    lists.add(st2);
	    lists.add(st3);
	    lists.add(st4);
	    lists.add(st5);
	    lists.add(st6);
	    lists.add(st7);
	    lists.add(st8);
	    lists.add(st9);
	    lists.add(st10);
	    
	    return lists;
	    
	}
	
	public static List<Employee> getEmployees() {
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee("A", 20, 20000));
		emps.add(new Employee("B", 50, 25000));
		emps.add(new Employee("C", 40, 20000));
		emps.add(new Employee("D", 25, 30000));
		emps.add(new Employee("E", 29, 40000));
		emps.add(new Employee("F", 30, 80000));
		emps.add(new Employee("g", 35, 20800));
		emps.add(new Employee("H", 33, 20000));
		emps.add(new Employee("I", 28, 60000));
		emps.add(new Employee("J", 38, 30000));
		
		return emps;
		
	}

}
