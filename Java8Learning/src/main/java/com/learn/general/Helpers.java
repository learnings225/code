package com.learn.general;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This is motivated by java.util.concurrent.Helpers
 * 
 * @author srimeda
 *
 */
public interface Helpers {

	/**
	 * Converts Object to String
	 */
	static Function<Object, String> objectToString = (x) -> Optional.ofNullable(x).map(Object::toString).orElse("null");

	/**
	 * Converts the collection of Strings to Upper case
	 */
	static Function<List<String>, List<String>> allToUpperCase = words -> words.stream().map(String::toUpperCase).collect(Collectors.toList());
	
	

}
