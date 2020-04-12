package com.chainofresponsibility.validation.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CompositePasswordRule extends ArrayList<Validator> implements Validator<String> {

	public CompositePasswordRule(Collection<Validator<?>> rules) {
		addAll(rules);
	}

	public CompositePasswordRule(Validator<?>... rules) {
		addAll(Arrays.asList(rules));
	}

	@Override
	public CompositeResult validate(String value) {
		CompositeResult result = new CompositeResult(size());
		for (Validator rule : this) {
			ValidationResult tempResult = rule.validate(value);
			if (!tempResult.isValid())
				result.put(rule, tempResult);
		}
		return result;
	}

}