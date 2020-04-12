package com.chainofresponsibility.validation.example;

public class AlphaNumericValidator implements Validator<String> {

	private final ValidationResult FAILED;

	public AlphaNumericValidator() {
		FAILED = new SimpleResult("The password should be alphanumeric.", false);
	}

	@Override
	public ValidationResult validate(String value) {
		return isAlphaNumeric(value) ? ValidationResult.OK : FAILED;
	}

	private boolean isAlphaNumeric(String s) {
		String pattern = "^[a-zA-Z0-9]*$";
		return s.matches(pattern);
	}
	
	@Override
	public String toString() {
		return "AlphaNumericValidator";
	}

}
