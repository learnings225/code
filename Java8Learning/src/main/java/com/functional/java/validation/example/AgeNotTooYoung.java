package com.functional.java.validation.example;

import cyclops.control.Validated;

public class AgeNotTooYoung {
	/**
	 * 
	 * @param user
	 * @return
	 */
	public static Validated<Error, String> ageOk(User user) {
		if (user.age >= 18) {
			return Validated.valid("Age is OK");
		}

		return Validated.invalid(Error.TOO_YOUNG);
	}
}
