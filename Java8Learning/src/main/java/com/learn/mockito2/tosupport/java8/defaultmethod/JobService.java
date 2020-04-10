package com.learn.mockito2.tosupport.java8.defaultmethod;

import java.util.Optional;
import java.util.stream.Stream;

public interface JobService {
    Optional<JobPosition> findCurrentJobPosition(Person person);

    /**
     *  Default method
     * @param person
     * @param jobPosition
     * @return
     */
    default boolean assignJobPosition(Person person, JobPosition jobPosition) {
        if(!findCurrentJobPosition(person).isPresent()) {
            person.setJobPosition(jobPosition);
            return true;
        } else {
            return false;
        }
    }

    Stream<JobPosition> listJobs(Person person);
}
