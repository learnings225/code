package com.learn.java8.features.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Optionals are classes that represent a value that can be present or absent.
 * 
 * @author srimeda
 *
 */
public class OptionalExample {
	
	/**
	 * Creating empty Optional
	 * 
	 * @throws Exception
	 */
	public void createEmptyOptional() throws Exception {
		Optional<String> empty = Optional.empty();
		if(empty.isPresent()) {
			throw new Exception();
		}
		
		System.out.println("Empty!!");
	}
	
	/**
	 * creating Optional on non-null value and get it to print the value
	 * 
	 * @throws Exception
	 */
	public void createOptionalOfNonNullValue() throws Exception {
		String name = "sample";
		Optional<String> nameOptional = Optional.of(name);
		if(!nameOptional.isPresent()) {
			System.err.println("Optional is Empty");
			throw new Exception();
		}
		
		System.out.println(nameOptional.get());
	}
	
	/**
	 * NPE when using 'of' method on null values.
	 */
	public void createOptionalOfNullValue() {
		String name = null;
		try {
			Optional<String> nameOptional = Optional.of(name);
		} catch(Exception e) {
			System.out.println("Expected NPE : " + e.getMessage());
		}

		System.err.println("ERROR!!");
	}
	
	/**
	 * ofNullable on non-null variable
	 * 
	 * @throws Exception
	 */
	public void createOptionalOfNonNullValueUsingOfNullable() throws Exception {
		String name = "sample";
		Optional<String> nameOptional = Optional.of(name);
//		if(nameOptional.isEmpty()) {
//			System.err.println("Optional is Empty");
//			throw new Exception();
//		}
		
		System.out.println(nameOptional.get());
	}
	
	/**
	 * ofNullable on null variable
	 * 
	 * @throws Exception
	 */
	public void createOptionalOfNullValueUsingOfNullable() throws Exception {
		String name = null;
		Optional<String> nameOptional = Optional.ofNullable(name);

		if(nameOptional.isPresent()) {
			throw new Exception();
		}
		
		System.err.println("Empty name!!");
	}
	
	/**
	 * isPresent Example
	 */
	public void isPresent() throws Exception {
		Optional<String> name = Optional.of("Srini");
		if (name.isPresent()) {
			System.out.println("Name is Present :: " + name.get());
		}

		name = Optional.ofNullable(null);
		if (name.isPresent()) {
			throw new Exception();
		}
	}
	
	/**
	 * Conditional expression using ifPresent
	 * 
	 */
	public void ifPresent() {
	    Optional<String> nameOptional = Optional.ofNullable("Srini");
	    nameOptional.ifPresent(name -> System.out.println(name.length()));
	}
	
	/**
	 * Gets the default value in the case the optional is empty using orElse
	 * @throws Exception 
	 */
	public void orElse() throws Exception {
		String nameInput = null;
		String name = Optional.ofNullable(nameInput).orElse("Srini");
		if(name.equalsIgnoreCase("Srini")) {
			System.out.println("Fount name!!");
		} else {
			throw new Exception();
		}
	}
	
	/**
	 * Similar to orElse to provide the default value, except that it takes a Supplier which gets executed and returns the value of the invocation
	 * 
	 * @throws Exception
	 */
	public void orElseGet() throws Exception {
		String nameInput = null;
		String name = Optional.ofNullable(nameInput).orElseGet(() -> "Srini");
		if(name.equalsIgnoreCase("Srini")) {
			System.out.println("Fount name!!");
		} else {
			throw new Exception();
		}
	}
	
	/**
	 * There is a subtle difference between orElse and orElseGet that can affect the performance of our code if we didn't understand well.
	 * 
	 * @throws Exception
	 */
	public void diffBetweenOrElseAndOrElseGet() throws Exception {
		String name = null;
		
		String defaultName = Optional.ofNullable(name).orElse(getDefaultName());
		defaultName = Optional.ofNullable(name).orElseGet(this :: getDefaultName);
		
		// The getDefaultName() method is called in each case. 
		// It so happens that when the wrapped value is not present, then both orElse() and orElseGet() work exactly the same way.
		
		// See the difference when the value is present
		name = "sri";
		System.out.println("Using orElseGet:");
		defaultName = Optional.ofNullable(name).orElseGet(this::getDefaultName);
	 
	    System.out.println("Using orElse:");
	    defaultName = Optional.ofNullable(name).orElse(getDefaultName());
	    
	    // Now, Notice that when using orElseGet() to retrieve the wrapped value, the getDefaultName() method is not even invoked since the contained value is present. 
	    // However, when using orElse(), whether the wrapped value is present or not, the default object is created by invoking getDefaultName method. 
	    
	    // Here the impact is minimal, but if getDefaultName() method calls a service or DB to get the name, then the cost is expensive.
	}
	
	private String getDefaultName() {
		System.out.println("Getting default name!!");
		return "default";
	}
	
	/**
	 * orElseThrow is used to throw an exception if the value of the option is empty
	 */
	public void orElseThrow() {
		String name = null;
		
		try {
			String result = Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);
		} catch(Exception e) {
			System.out.println("Expected Illegal Argument Exception!!");
		}
	}
	
	public void retrieveValueUsingGet() throws Exception {
		Optional<String> nameOptional = Optional.of("sree");
	    String name = nameOptional.get();
	    if(!"sree".equalsIgnoreCase(name)) {
	    	throw new Exception();
	    }
	    
	    System.out.println(name);
	    
	    // Unlike using orElse and orElseGet, get() can only result value if the wrapped object is non-null. Otherwise, it throws NoSuchElementException
	    nameOptional = Optional.ofNullable(null);
	    
	    try {
	    	name = nameOptional.get();
	    } catch(NoSuchElementException e) {
	    	System.out.println("Expected NoSuchElementException!!");
	    }
	    
	    // The Optional.get() method can throw a NoSuchElementException when called on an empty Optional. This is the major flaw of get() method. Optional should help us avoid such unforeseen exceptions.
	    // Therefore, this approach works against the objectives of Optional and will probably be deprecated in a future release.
	    // It is, therefore, advisable to use the other variants which enable us to prepare for and explicitly handle the null case.
	}
	
	/**
	 * The filter method is normally used this way to reject wrapped values based on a predefined rule.
	 */
	public void conditionalReturnWithFilter() {
		Integer year = 2016;
		
		Optional<Integer> yearOptional = Optional.of(year);
		
		boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
		System.out.println("Is the year 2016?? " + is2016);
		
		boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
		System.out.println("Is the year 2017?? " + is2017);
	}
	
	/**
	 * Lets take a look at another meaningful example. Let's say we want to buy a modem and we only care about its price. We receive push notifications on modem prices from a certain site and store these in objects
	 */
	class Modem {
		private Double price;
		
		public Modem(Double price) {
			this.price = price;
		}
		
		public Double getPrice() {
			return price;
		}
		
		public void setPrice(Double price) {
			this.price = price;
		}
	}
	
	private boolean priceIsInRange1(Modem modem) {
	    boolean isInRange = false;
	 
	    if (modem != null && modem.getPrice() != null
	      && (modem.getPrice() >= 10 && modem.getPrice() <= 15)) {
	        isInRange = true;
	    }
	    
	    return isInRange;
	}
	
	public void filtersWithoutOptional() {
	    System.out.println(priceIsInRange1(new Modem(10.0)));
	    System.out.println(priceIsInRange1(new Modem(9.9)));
	    System.out.println(priceIsInRange1(new Modem(null)));
	    System.out.println(priceIsInRange1(new Modem(15.5)));
	    System.out.println(priceIsInRange1(null));
	}
	
	// Now let us look at a variant with Optional#filter:

	public boolean priceIsInRange2(Modem modem2) {
		return Optional.ofNullable(modem2)
				.map(Modem::getPrice)
				.filter(p -> p >= 10)
				.filter(p -> p <= 15)
				.isPresent();
	} // The map call is simply used to transform a value to some other value. Keep in mind that this operation does not modify the original value.
	
	
	/**
	 * Main Method
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		OptionalExample oe = new OptionalExample();
		oe.createEmptyOptional();
		oe.createOptionalOfNonNullValue();
		oe.createOptionalOfNullValue();
		oe.createOptionalOfNonNullValueUsingOfNullable();
		oe.createOptionalOfNullValueUsingOfNullable();
		oe.isPresent();
		oe.ifPresent();
		oe.orElse();
		oe.orElseGet();
		oe.diffBetweenOrElseAndOrElseGet();
		oe.orElseThrow();
		oe.retrieveValueUsingGet();
		oe.conditionalReturnWithFilter();
		oe.filtersWithoutOptional();
	}
}


// References
// https://www.baeldung.com/java-optional
// https://javadevcentral.com/a-complete-guide-to-java-optional
// https://javadevcentral.com/optional-new-methods
// 
