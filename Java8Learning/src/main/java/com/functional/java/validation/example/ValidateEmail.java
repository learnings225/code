package com.functional.java.validation.example;

import cyclops.control.Validated;

public class ValidateEmail {
	public static Validated<Error, String> emailOk(User user) {
		if (user.email != null) {
			return Validated.valid("email is OK!!");
		}

		return Validated.invalid(Error.NO_EMAIL);
	}
}
