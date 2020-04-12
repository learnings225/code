package com.chainofresponsibility.validation.example;

public class Main {
	public static void main(String[] args) throws Exception {
		Validator<String> pwRule = new CompositePasswordRule(new MinLengthValidator(), new AlphaNumericValidator());
		ValidationResult result = pwRule.validate("Test45");
		if (!result.isValid()) {
			throw new Exception(result.getMessage());
		}

		System.out.println("All Checks Passed:\n" + result);
	}
}
