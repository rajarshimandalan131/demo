package com.practice.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {

	public static void main(String[] args) {
		List<Integer> list = List.of(4, 50, 16, 71, 43, 21, 1, 10);
//				List.of(4, 50, 16, 71, 43, 21, 1, 10); immutable
//				Arrays.asList(1,2,3); immutable
//				new ArrayList<>(List.of(4, 50, 16, 71, 43, 21, 1, 10)); immutable
//				new ArrayList<>(Arrays.asList(1,2,3)); mutable
		
		System.out.println(list);
		
		//without using stream API
		
		List<Integer> res = new ArrayList<>();
		
		for(Integer item : list) {
			if(item%2==0)
				res.add(item);
		}
		System.out.println(res);
		
		res = list.parallelStream().filter(i -> i%2==0).toList();
		System.out.println("with stream : " + res);
		System.out.println("sum " + list.stream().filter(i -> i%2==0).mapToInt(e->e).sum());
		System.out.println("count " + list.stream().filter(i -> i%2==0).mapToInt(e->e).count());
		System.out.print("average " + list.stream().filter(i -> i%2==0).mapToInt(e->e).average().orElse(0.0));
		
		res = list.stream().filter(i -> i%2==0).toList();
		System.out.println("\nwith stream collected: " + res);
		
		/*
		 * //inline print list.stream().filter(i ->
		 * i%2==0).toList().forEach(System.out::println);
		 * Arrays.asList("abcbd".split("")).forEach(System.out::println);
		 */
		List<String> names = List.of("abc", "bcd", "Ab", "xy", "ZZ");
		names.stream().filter(e -> Character.isUpperCase(e.charAt(0))).map(e -> e=e.toUpperCase()).forEach(System.out::print);
		
		System.out.println("\nUsing reducer : " + names.stream().reduce("hello", (a,b)->a+b));
		
		//sorting elements and join
		System.out.println("\nwithout sort : "+names.stream().collect(Collectors.joining("-")));
		System.out.println("with sort : "+names.stream().sorted().collect(Collectors.joining("-")));
		
		//occurrence count from list of strings
		names.stream().
		flatMap(e -> e.chars().mapToObj(c -> (char) c)) // Stream<Character>
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> System.out.print(k + " : " + v + " ,"));
		//or
		System.out.println("\nother way : " + names.toString());
		Arrays.stream(String.join("", names).split(""))
//		flatMap(e -> e.chars().mapToObj(c -> (char) c)) // Stream<Character>
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> System.out.print(k + " : " + v + " ,"));
		
		
		//occurrence count from a string
		String str = "hello world, able to find occurence of each character and print the counts";
		System.out.println("\n" +str);
		Arrays.stream(str.split("")).map(e -> e.equals(" ") ? "SPACE" : e) 
		        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> System.out.print(k + " : " + v + " ,"));
		
		System.out.println("\ndistinct");
		Arrays.stream(str.split("")).map(e -> e.equals(" ") ? "SPACE" : e).distinct() 
        .collect(Collectors.toList()).forEach(System.out::print);
		
		System.out.println("\nskip space and limit 10 elements");
		Arrays.stream(str.split("")).map(e -> e.equals(" ") ? "SPACE" : e).distinct().skip(5).limit(10) 
		.collect(Collectors.toList()).forEach(System.out::print);
		
		System.out.println("\nfind first");
		Arrays.stream(str.split("")).map(e -> e.equals(" ") ? "SPACE" : e).distinct().skip(5).limit(10)
		.findFirst().ifPresent(System.out::print);
		
		System.out.println("\nfind any");
		Arrays.stream(str.split("")).map(e -> e.equals(" ") ? "SPACE" : e).distinct().skip(5).limit(10)
		.findAny().ifPresent(System.out::print);
		
//		.collect(Collectors.toList()).forEach(System.out::println);
	}

}
