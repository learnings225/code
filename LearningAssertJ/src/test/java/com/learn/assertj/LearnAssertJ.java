package com.learn.assertj;

//entry point for all assertThat methods and utility methods (e.g. entry)
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class LearnAssertJ {

	@Test
	public void testPerson() {
		Person sam = new Person();
		sam.setFirstName("Sam");
		sam.setLastName("last");
		sam.setAge(24);
		Address address1 = new Address();
		address1.setStreet1("1st Street");
		sam.setAddress(address1);
		
		Person peter = new Person();
		peter.setFirstName("Peter");
		peter.setLastName("last");
		peter.setAge(21);
		Address address2 = new Address();
		address2.setStreet1("Southwest Expy");
		peter.setAddress(address2);
		
		// basic assertions
		assertThat(sam.getFirstName()).isEqualTo("Sam");
		assertThat(sam).isNotEqualTo(peter);

		// chaining string specific assertions
		assertThat(sam.getFirstName()).startsWith("Sa").endsWith("am").isEqualToIgnoringCase("sam");

		Person three = new Person();
		three.setFirstName("three");
		three.setLastName("last");
		three.setAge(32);
		Address address = new Address();
		address.setStreet1("Main Road");
		three.setAddress(address);
		
		List<Person> persons = Stream.of(sam, peter, three).collect(Collectors.toList());
		
		Person four = new Person();
		four.setFirstName("four");
		four.setLastName("last");
		four.setAge(32);
		
		// collection specific assertions (there are plenty more)
		// in the examples below fellowshipOfTheRing is a List<TolkienCharacter>
		assertThat(persons).hasSize(3).contains(peter, sam, three).doesNotContain(four);

		// as() is used to describe the test and will be shown before the error message
		assertThat(peter.getAge()).as("check %s's age", peter.getFirstName()).isEqualTo(21);

		// exception assertion, standard style ...
		assertThatThrownBy(() -> {
			throw new Exception("boom!");
		}).hasMessage("boom!");
		
		// ... or BDD style
		Throwable thrown = catchThrowable(() -> {
			throw new Exception("boom!");
		});
		assertThat(thrown).hasMessageContaining("boom");

		// using the 'extracting' feature to check fellowshipOfTheRing character's names
		assertThat(persons).extracting(Person::getFirstName).doesNotContain("Sauron", "Elrond");

		// extracting multiple values at once grouped in tuples
		assertThat(persons).extracting("firstName", "age", "address.street1").contains(tuple("three", 32, "Main Road"),
				tuple("Sam", 24, "1st Street"), tuple("Peter", 21, "Southwest Expy"));

		// filtering a collection before asserting
		assertThat(persons).filteredOn(character -> character.getFirstName().contains("t")).containsOnly(peter, three);

		// combining filtering and extraction (yes we can)
		assertThat(persons).filteredOn(character -> character.getFirstName().contains("t"))
				.containsOnly(peter, three).extracting(character -> character.getAddress().getStreet1())
				.contains("Main Road", "Southwest Expy");

		// and many more assertions: iterable, stream, array, map, dates, path, file,
		// numbers, predicate, optional ...
	}
}
