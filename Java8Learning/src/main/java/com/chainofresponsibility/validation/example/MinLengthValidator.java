package com.chainofresponsibility.validation.example;

public class MinLengthValidator implements Validator<String> {
	private final ValidationResult FAILED;
	private Integer minLength;

	public MinLengthValidator() {
		this(8);
	}

	public MinLengthValidator(Integer minLength) {
		this.minLength = minLength;
		FAILED = new SimpleResult("Password must be at least " + minLength
				+ " characters long.", false);
	}

	@Override
	public ValidationResult validate(String value) {
		return value.length() >= minLength ? ValidationResult.OK : FAILED;
	}
	
	@Override
	public String toString() {
		return "MinLengthValidator";
	}
}
