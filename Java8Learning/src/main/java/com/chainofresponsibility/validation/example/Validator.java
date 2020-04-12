package com.chainofresponsibility.validation.example;

public interface Validator<T> {
	public ValidationResult validate(T t);
}
