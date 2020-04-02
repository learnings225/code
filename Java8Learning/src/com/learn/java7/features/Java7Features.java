package com.learn.java7.features;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author srimeda
 *
 */
public class Java7Features {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
//		1. Diamond Operator
//		Map<String, Set<String>> rowsMap = new HashMap<>();
//		rowsMap.clear();
		
//      2. Strings in switch Statement
		
//		String country = "ABCD";
//		switch (country) {
//		case "UK":
//		case "US":
//			System.out.println("US or UK!");
//			break;
//		case "DE":
//			System.out.println("DE!!");
//			break;
//		default:
//			System.out.println("default country!");
//		}
		
//		3. Multi-Catch similar exceptions
//		and 		
//		More precise Exception rethrow
		try {
			rethrowException("1234");
		} catch(FirstException | SecondException e){
			System.out.println(e.getMessage());
		}
		
//		4. Automatic resource closing or management using try with resources
		
//		try {
//			// open resources
//		} catch (Exception e) {
//			// handle exception
//		} finally {
//			// close resources
//		}
		
		String filePath = "/Users/srimeda/test.txt";
//		try (BufferedReader b = new BufferedReader(new FileReader(filePath))) {
//			String s;
//			while ((s = b.readLine()) != null) {
//				System.out.println(s);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//Benefits
//		More readable code and easy to write. Concise.
//		No need of finally block just to close the resources. Automatic resource management.
//		We can open multiple resources in try-with-resources statement separated by a semicolon.
		try (BufferedReader br = new BufferedReader(new FileReader(filePath));
				java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(FileSystems.getDefault().getPath("/Users/srimeda/write.txt"), Charset.defaultCharset())) {
			String s = br.readLine();
			writer.append(s);
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		5. Underscore in Numeric Literals
		int million = 1_000_000;
		long creditCardNumber = 1234_5678_9012_3456L;
		float num = 1.2345_6789f;
//		
//		System.out.println(million + 2);
//		System.out.println(creditCardNumber);
//		System.out.println(num);
		
		
//		6. Binary Literals with Prefix “0b"
		int maskBytes = 0b11001100;
		System.out.println(maskBytes);
		
//		using underscore for improved readability
		int veryLongMask = 0b1101_1000_1101_0001;
		System.out.println(veryLongMask);
		
		// Java NIO 2.0 changes
//		Path path = Paths.get("/Users/srimeda/test.txt");
//		System.out.println("Path Name Count: " + path.getNameCount());
//		System.out.println("Parent Folder: " + path.getParent());
		
//		Fork Join Framework
//	    The fork/join framework is an implementation of ExecutorService interface that allows to take advantage of multiple processors available in modern servers.
//	    It is designed for work that can be broken into smaller pieces recursively.
//	    The goal is to use all the available processing power to enhance the performance of the Application.
//	    The fork join framework is distinct because it uses work stealing algorithm, 
//		which is very different from Producer consumer algorithm. 
//		https://en.wikipedia.org/wiki/Work_stealing
	}
	
	
	/**
	 * The Java SE 7 compiler performs more precise analysis of rethrown exceptions than earlier releases of Java SE. 
	 * This enables you to specify more specific exception types in the throws clause of a method declaration.
	 * 
	 * @param exceptionName
	 * @throws FirstException
	 * @throws SecondException
	 */
	public static void rethrowException(String exceptionName) throws FirstException, SecondException {
		try {
			if (exceptionName.equalsIgnoreCase("First")) {
				throw new FirstException();
			} else {
				throw new SecondException();
			}
		} catch (Exception e) {
			throw e;
		}
	}
}

class FirstException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;}

class SecondException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;}
