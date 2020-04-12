package com.chainofresponsibility.validation.example;

import java.util.HashMap;

public class CompositeResult extends HashMap<Validator, ValidationResult> implements ValidationResult {

	private Integer appliedCount;

	public CompositeResult(Integer appliedCount) {
		this.appliedCount = appliedCount;
	}

	@Override
	public boolean isValid() {
		boolean isOk = true;
		for (ValidationResult r : values()) {
			isOk = r.isValid();
			if (!isOk)
				break;
		}
		return isOk;
	}

	@Override
	public String getMessage() {
		return toString();
	}

	public Integer failCount() {
		return size();
	}

	public Integer passCount() {
		return appliedCount - size();
	}

}
