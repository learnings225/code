package com.chainofresponsibility.validation.example;

public interface ValidationResult {
	public static final ValidationResult OK = new ValidationResult() {

		@Override
		public boolean isValid() {
			return true;
		}

		@Override
		public String getMessage() {
			return "OK";
		}
		
	};
	
	public boolean isValid();
	public String getMessage();
}
