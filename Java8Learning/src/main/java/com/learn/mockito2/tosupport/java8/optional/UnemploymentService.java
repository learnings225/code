package com.learn.mockito2.tosupport.java8.optional;

import com.learn.mockito2.tosupport.java8.defaultmethod.JobPosition;
import com.learn.mockito2.tosupport.java8.defaultmethod.Person;

import java.util.Optional;

public interface UnemploymentService {
    boolean isPersonEntitledToUnEmploymentSupport(Person person);

    Optional<JobPosition> searchJob(Person person, String searchString);
}
