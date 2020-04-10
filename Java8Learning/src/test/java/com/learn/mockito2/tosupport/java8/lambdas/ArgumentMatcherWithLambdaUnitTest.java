package com.learn.mockito2.tosupport.java8.lambdas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.learn.mockito2.tosupport.java8.defaultmethod.JobPosition;
import com.learn.mockito2.tosupport.java8.defaultmethod.JobService;
import com.learn.mockito2.tosupport.java8.defaultmethod.Person;
import com.learn.mockito2.tosupport.java8.optional.UnemploymentServiceImpl;

public class ArgumentMatcherWithLambdaUnitTest {

	@Mock
	private JobService jobService;
	
	@InjectMocks
	private UnemploymentServiceImpl unemploymentService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void whenPersonWithJob_thenIsNotEntitled() {
		Person peter = new Person("Peter");
        Person lynda = new Person("Lynda");
        
        JobPosition teacher = new JobPosition("Teacher");
        
        when(jobService.findCurrentJobPosition(
        		ArgumentMatchers.argThat((p) -> p.getName().equalsIgnoreCase("Peter")))
        ).thenReturn(Optional.of(teacher));
        
        assertTrue(unemploymentService.isPersonEntitledToUnEmploymentSupport(lynda));
		assertFalse(unemploymentService.isPersonEntitledToUnEmploymentSupport(peter));
	}
}
