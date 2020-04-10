package com.learn.mockito2.tosupport.java8.defaultmethod;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;

/**
 * Test class to test the default method behavior in an interface
 *
 * @author srimeda
 */
public class JobServiceUnitTest {

    @Mock
    private JobService jobService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenDefaultMethod_whenCallRealMethod_thenNoExceptionIsRaised() {
        Person person = new Person();

        when(jobService.findCurrentJobPosition(person)).thenReturn(Optional.of(new JobPosition()));

        doCallRealMethod().when(jobService)
                .assignJobPosition(Mockito.any(Person.class), Mockito.any(JobPosition.class));

        assertFalse(jobService.assignJobPosition(person, new JobPosition()));
    }

    @Test
    public void givenReturnIsOfTypeOptional_whenDefaultValueIsReturned_thenValueIsEmpty() {
        Person person = new Person();

        when(jobService.findCurrentJobPosition(person)).thenReturn(Optional.empty());

        doCallRealMethod().when(jobService)
                .assignJobPosition(Mockito.any(Person.class), Mockito.any(JobPosition.class));

        assertTrue(jobService.assignJobPosition(person, new JobPosition()));
    }
}