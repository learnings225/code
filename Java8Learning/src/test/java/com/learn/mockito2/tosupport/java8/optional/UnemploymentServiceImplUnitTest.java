package com.learn.mockito2.tosupport.java8.optional;

import com.learn.mockito2.tosupport.java8.defaultmethod.JobService;
import com.learn.mockito2.tosupport.java8.defaultmethod.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UnemploymentServiceImplUnitTest {

    @Mock
    private JobService jobService;

    @InjectMocks
    private UnemploymentServiceImpl unemploymentService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenReturnIsOfTypeOptional_whenMocked_thenValueIsEmpty() {
        Person person = new Person();

        // This when(…).thenReturn(…) instruction is necessary because Mockito's default return value for any method calls to a mocked object is null.
        // Version 2 changed that behavior.
        // You can see the below test case for example, where it will return Optional.empty() instead of null as return value in case of mocking.
        when(jobService.findCurrentJobPosition(any(Person.class)))
                .thenReturn(Optional.empty());

        assertTrue(unemploymentService.isPersonEntitledToUnEmploymentSupport(person));
    }

    @Test
    public void givenReturnIsOfTypeOptional_whenDefaultValueIsReturned_thenValueIsEmpty() {
        Person person = new Person();

        //So, when using Mockito version 2, we could get rid of when(..).thenReturn() and our test would still be successful.

        assertTrue(unemploymentService.isPersonEntitledToUnEmploymentSupport(person));
    }

    @Test
    public void givenReturnIsOfTypeStream_whenMocked_thenValueIsEmpty() {
        Person person = new Person();
        // Before Mockito 2, we would need to mock the call to listJobs()
        when(jobService.listJobs(any(Person.class))).thenReturn(Stream.empty());
        assertFalse(unemploymentService.searchJob(person, "").isPresent());
    }

    @Test
    public void givenReturnIsStream_whenDefaultValueIsReturned_thenValueIsEmpty() {
        Person person = new Person();
        // With Mockito 2 we don't need below when thenReturn
        // Mockito will return an empty Stream on mocked methods by default:
//        when(jobService.listJobs(any(Person.class))).thenReturn(Stream.empty());

        assertFalse(unemploymentService.searchJob(person, "").isPresent());
    }
}
