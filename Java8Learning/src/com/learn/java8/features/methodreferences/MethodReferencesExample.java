package com.learn.java8.features.methodreferences;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;

public class MethodReferencesExample {
	public static void main(String[] args) {

// Static Method reference

		// Using a lambda expression
		Function<Integer, String> func1 = x -> Integer.toHexString(x);
		System.out.println(func1.apply(10));

		// Using a method reference
		Function<Integer, String> func2 = Integer::toHexString;
		System.out.println(func2.apply(10));

// Instance Method

		// Using specific instance
		Printer p = new Printer();

		Consumer<String> consumer = str -> p.print(str);
		consumer.accept("Hello");

		Consumer<String> consumer1 = p::print;
		consumer1.accept("Srini");
		
		// Using class name
		Function<String,  Integer> strLengthFunc = String::length; // str -> str.length();
		String name ="sample";
	    int len   =  strLengthFunc.apply(name); 
	    System.out.println("name  = "  +  name + ", length = "  + len);

// Super type instance method reference
	    abstract class SuperClass {
	        void method() { 
	            System.out.println("superclass method()");
	        }
	    }

	    class SubClass extends SuperClass {
	        @Override
	        void method() {
	            Runnable superMethodWithLambda = () -> super.method();
	            Runnable superMethodWithMethodRef = SubClass.super::method;
	        }
	    }

// Constructor Method Reference
		PrinterFactory pf = Printer::new;
		pf.get().print("How are you!!");

// Array Constructor reference
		IntFunction<int[]> arrayCreator1 = size ->  new int[size];
	    // Creates an integer array with five  elements
	    int[] intArray1  = arrayCreator1.apply(5);
	    System.out.println(Arrays.toString(intArray1));

	    IntFunction<int[]> arrayCreator2 = int[]::new;
	    int[] intArray2 = arrayCreator2.apply(5); 
	    System.out.println(Arrays.toString(intArray2));
	}
}

interface PrinterFactory {
	Printer get();
}

class Printer {
	public void print(String s) {
		System.out.println(s);
	}
}