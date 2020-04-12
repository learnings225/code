package com.functional.java.validation.example;

import cyclops.companion.Semigroups;
import cyclops.control.Validated;

/**
 * Example of Cyclops
 * 
 * https://github.com/aol/cyclops
 * https://medium.com/@johnmcclean/dysfunctional-programming-in-java-a-functional-tutorial-20e0bebd2ec9
 * @author srimeda
 *
 */
public class Main {
	public static void main(String[] args) {
		User user1 = new User(5, "sample@gmail.com");

		Validated<Error, String> r1 = AgeNotTooYoung.ageOk(user1).combine(Semigroups.stringConcat,
				ValidateEmail.emailOk(user1));

		System.out.println(r1);
		
		User user2 = new User(5, null);

		Validated<Error, String> r2 = AgeNotTooYoung.ageOk(user2).combine(Semigroups.stringConcat,
				ValidateEmail.emailOk(user2));
		System.out.println(r2);
		
		User user3 = new User(21, "sample@gmail.com");

		Validated<Error, String> r3 = AgeNotTooYoung.ageOk(user3).combine(Semigroups.stringConcat,
				ValidateEmail.emailOk(user3));
		System.out.println(r3);
		
		Validated<Error, String> r4 = AgeNotTooYoung.ageOk(user3).combine(Semigroups.stringJoin(", "),
				ValidateEmail.emailOk(user3));
		System.out.println(r4);
		
		if(r4.isValid()) {
			System.out.println("All the validations passed!!");
		}
	}
}
