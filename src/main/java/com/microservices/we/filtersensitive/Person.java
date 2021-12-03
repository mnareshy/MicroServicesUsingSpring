package com.microservices.we.filtersensitive;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

//@Component
@JsonFilter("PersonFilter")
public class Person {

    String name;
    String age;

    //static filtering - use @JsonIgnore from fasterxml

    //@JsonIgnore
    String password;
  //@JsonIgnore
    String ssn;

    public Person() {
    }

    public Person(String name, String age, String password, String ssn) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }



}
