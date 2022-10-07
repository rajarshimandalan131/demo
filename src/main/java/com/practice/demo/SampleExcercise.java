package com.practice.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.practice.demo.model.Employee;

public class SampleExcercise {
	
	public static void main(String args[]) {
		int val = 10;
		updateVal(val);
		System.out.println(val);
		
		Map<Integer, Object> map = new TreeMap<>();
		map.put(5, 5);
		map.put(6, "7");
		map.forEach((k,v) -> System.out.print(k + ":" + v));		
		List<Employee> list = Arrays.asList(
					new Employee(0, "ccd", "bcd", "abc@bcd.com"),
					new Employee(0, "abc", "bcd", "abc@bcd.com"),
					new Employee(0, "bcc", "bcd", "abc@bcd.com"),
					new Employee(0, "eff", "bcd", "abc@bcd.com"),
					new Employee(0, "dcc", "bcd", "abc@bcd.com"),
					new Employee(0, "007", "bcd", "abc@bcd.com")
				);
		Collections.sort(list,(o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
		
		Consumer<Employee> con = wrapperLambda(System.out::println);
		list.forEach(con);
		
		System.out.println("Get employee names ending with 'c'");
		Function<Employee, Boolean> fun = o1 -> o1.getFirstName().endsWith("c");
		list.forEach( item -> {
			if(fun.apply(item)) {
				con.accept(item);
			}
		});
		
		System.out.println("Printing again");
		Predicate<Employee> p = o1 -> o1.getFirstName().endsWith("c");
		list.forEach( item -> {
			if(p.test(item)) {
				con.accept(item);
			}
		});
	}

	private static void updateVal(int val) {
		val = 20;
	}

	private static Consumer<Employee> wrapperLambda(Consumer<Employee> consumer) {
		return emp -> {
			try {
				if(emp.getFirstName().equals("007")) {
					throw new Exception("Details of 007 can not be disclosed");
				}
				consumer.accept(emp);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		};
	}
	
}

