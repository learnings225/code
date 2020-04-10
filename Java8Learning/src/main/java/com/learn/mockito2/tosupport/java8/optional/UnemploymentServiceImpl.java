package com.learn.mockito2.tosupport.java8.optional;

import com.learn.mockito2.tosupport.java8.defaultmethod.JobPosition;
import com.learn.mockito2.tosupport.java8.defaultmethod.JobService;
import com.learn.mockito2.tosupport.java8.defaultmethod.Person;

import java.util.Optional;
import java.util.stream.Stream;

public class UnemploymentServiceImpl implements UnemploymentService {
    private final JobService jobService;

    public UnemploymentServiceImpl(JobService jobService) {
        this.jobService = jobService;
    }

    @Override
    public boolean isPersonEntitledToUnEmploymentSupport(Person person) {
        Optional<JobPosition> jobPositionOptional = jobService.findCurrentJobPosition(person);
        return !jobPositionOptional.isPresent();
    }

    @Override
    public Optional<JobPosition> searchJob(Person person, String searchString) {
        Stream<JobPosition> jobPositionStream = jobService.listJobs(person);

        return jobPositionStream.filter((j) -> j.getTitle().contains(searchString)).findFirst();
    }
}
