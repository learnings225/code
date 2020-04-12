package com.chainofresponsibility.validation.example;

public class SimpleResult implements ValidationResult {

	private String message;
	private boolean valid;

	public SimpleResult() {
		this(null, true);
	}

	public SimpleResult(boolean valid) {
		this(null, valid);
	}

	public SimpleResult(String message, boolean valid) {
		if (message != null && message.length() > 0) {
			this.message = message;
		} else {
			message = "Validation " + (valid ? "Successful" : "Failed");
		}
		
		this.valid = valid;
	}

	@Override
	public boolean isValid() {
		return valid;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
