package com.learn.mockito2.tosupport.java8.defaultmethod;

//import lombok.Getter;

//@Getter
public class Person {
    private String name;
    private JobPosition jobPosition;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }
}
