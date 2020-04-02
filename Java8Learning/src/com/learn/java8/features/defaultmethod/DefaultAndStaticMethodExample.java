package com.learn.java8.features.defaultmethod;

import java.time.LocalDate;

public class DefaultAndStaticMethodExample {
	public static void main(String[] args) {
		Printer p1 = new InkJetPrinter();
		p1.print();
		p1.logDetails();
		
		Printer p2 = new LaserPrinter();
		p2.print();
		p2.logDetails();
	}
	
}

interface Printer {
	public void print(); // abstract method
	
	default void logDetails() {
		System.out.println("Printed a job at " + LocalDate.now());
	}
}

class InkJetPrinter implements Printer {

	@Override
	public void print() {
		System.out.println("Printed with ink jet printer!!");
	}
	
	public void logDetails() {
		System.out.println("Printed job using inkjet printer at " + LocalDate.now());
	}
}

class LaserPrinter implements Printer {
	@Override
	public void print() {
		System.out.println("Printed with ink jet printer!!");
	}
}