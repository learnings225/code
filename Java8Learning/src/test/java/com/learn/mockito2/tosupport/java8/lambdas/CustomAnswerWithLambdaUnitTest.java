package com.learn.mockito2.tosupport.java8.lambdas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.learn.mockito2.tosupport.java8.defaultmethod.JobPosition;
import com.learn.mockito2.tosupport.java8.defaultmethod.JobService;
import com.learn.mockito2.tosupport.java8.defaultmethod.Person;
import com.learn.mockito2.tosupport.java8.optional.UnemploymentServiceImpl;

public class CustomAnswerWithLambdaUnitTest {

    @InjectMocks
    private UnemploymentServiceImpl unemploymentService;

    @Mock
    private JobService jobService;

    @Test
    public void whenPersonWithJobHistory_thenSearchReturnsValue() {
        Person peter = new Person("Peter");

        assertEquals("Teacher", unemploymentService.searchJob(peter, "").get().getTitle());
    }

    @Test
    public void whenPersonWithNoJobHistory_thenSearchReturnsEmpty() {
        Person linda = new Person("Linda");

        assertFalse(unemploymentService.searchJob(linda, "").isPresent());
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        when(jobService.listJobs(any(Person.class))).then((i) ->
          Stream.of(new JobPosition("Teacher"))
          .filter(p -> ((Person) i.getArgument(0)).getName().equals("Peter")));
    }
}