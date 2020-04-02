package com.learn.java8.features.functionalinterfaces.comparator;

import java.util.Comparator;
import java.util.function.Consumer;

public class ComparatorExample {
	
	public static void main(String[] args) {
		
		/**
		 * Conventional way of defining the comparator
		 */
		Comparator<Person> traditionalComparator = new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				int cmp = p1.getFirstName().compareTo(p2.getFirstName());
				if(cmp == 0) {
					cmp = p1.getLastName().compareTo(p2.getLastName());
					if(cmp == 0) {
						return p1.getAge().compareTo(p2.getAge());
					} else {
						return cmp;
					}
				} else {
					return cmp;
				}
			}
		};
		
		/**
		 * Functional Programming style
		 * 
		 */
		Comparator<Person> functionalComparator = Comparator.comparing(Person::getFirstName)
														.thenComparing(Person::getLastName)
														.thenComparing(Person::getAge);
		
		Person p1 = new Person("P1FirstName", "P1LastName", 12);
		Person p2 = new Person("P2FirstName", "P2LastName", 23);
		
		System.out.println("Using Traditional way : " + traditionalComparator.compare(p1, p2));
		
		System.out.println("Using Functional way: " + functionalComparator.compare(p1, p2));
		
	}
}

class Person {
	String firstName;
	String lastName;
	Integer age;
	
	public Person(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
