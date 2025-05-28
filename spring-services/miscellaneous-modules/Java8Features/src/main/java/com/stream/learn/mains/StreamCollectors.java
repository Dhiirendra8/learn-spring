package com.stream.learn.mains;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.stream.learn.data.StaticData;
import com.stream.learn.model.Employee;
import com.stream.learn.model.Student;

public class StreamCollectors {

	public static void main(String[] args) {
		List<Student> students = StaticData.getStudents();
		//id, name, age, email
		
		//grouping by id, students obj
		Map<Integer, List<Student>> StudentsGroupingById = students.stream()
				.collect(Collectors.groupingBy(Student::getId));
		//grouping by id, students name only
		Map<Integer, List<String>> StudentsGroupingById1 = 
				students.stream()
				.collect(Collectors.groupingBy(Student::getId , 
						Collectors.mapping(Student::getName, Collectors.toList())));
		
		//grouping by name, students id only
		Map<String, List<Integer>> StudentsGroupingByName1 = 
				students.stream()
				.collect(Collectors.groupingBy(Student::getName , 
						Collectors.mapping(Student::getId, Collectors.toList())));
		
		
		System.out.println(StudentsGroupingById);
		System.out.println(StudentsGroupingById1);
		System.out.println(StudentsGroupingByName1);
//		System.out.println(StudentsGroupingById);
		
		
//		=====================================================================
		
		
		List<Employee> emps = StaticData.getEmployees();
		
		//s + s*10/100
		//s(11/10)
		
		List<Employee>  outEmps = emps.stream()
//			.map(e -> new Employee(e.getName(), e.getAge(), e.getAge()>30? e.getSalary()*11/10 : e.getSalary()))
			.map(e -> {
				if (e.getAge()>30) 
					e.setSalary(e.getSalary()*11/10);
				return e;
				
			})	
			.collect(Collectors.toList());
		
		//other method 2
		 List<Employee>  partitionBySalaryEmps = 
				emps.stream().collect(Collectors.partitioningBy(e -> e.getSalary()>30))
					.entrySet().stream()
					.map(m -> {
						if(m.getKey().booleanValue()) {
							List<Employee> emps1 = m.getValue();
							emps1.stream().map(i->{ 
								i.setSalary(0);
								return i;});
						}
						return m.getValue();
						})
					.flatMap(l -> l.stream())
					.collect(Collectors.toList());
		//other method 3
		 List<Employee>  groupingBySalaryEmps = 
				emps.stream().collect(Collectors.groupingBy(e -> e.getSalary()>30))
					.entrySet().stream()
					.map(m -> {
						if(m.getKey().booleanValue()) {
							List<Employee> emps1 = m.getValue();
							emps1.stream().map(i->{ 
								i.setSalary(0);
								return i;});
						}
						return m.getValue();
						})
					.flatMap(l -> l.stream())
					.collect(Collectors.toList());
		System.out.println("1st Method - " + outEmps);
		System.out.println("2nd Method - " +partitionBySalaryEmps);
		System.out.println("3rd Method - " +groupingBySalaryEmps);


		List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
		Map<String,List<Integer>> m = list.stream().collect(Collectors.groupingBy(i -> i%2==0?"Even":"Odd"));
		System.out.println(m);
	}
	

	
	
	
}
