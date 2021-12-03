package com.microservices.we.filtersensitive;


import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonService {

   @GetMapping("/person")
    public MappingJacksonValue getPerson(){

       //dynamic filtering

       Person person = new Person("sairam","22","dfsdfgadfg","klj323j2oi3j");

       SimpleBeanPropertyFilter simpleBeanPropertyFilter  = SimpleBeanPropertyFilter.filterOutAllExcept("password","ssn");
       FilterProvider filterProvider = new SimpleFilterProvider().addFilter("PersonFilter",simpleBeanPropertyFilter);

       MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(person);
       mappingJacksonValue.setFilters(filterProvider);

       return mappingJacksonValue;

    }

    @GetMapping("/persons")
    public MappingJacksonValue getPersonList(){

       //dynamic filtering

        List<Person> personList =  new ArrayList<>();

        personList.add( new Person("sairam","22","dfsdfgadfg","klj32453t33j2oi3j"));
        personList.add( new Person("naresh","42","dfsdfgadfasdfg","k234tflj323j2oi3j"));
        personList.add( new Person("siva","82","dfsdfgadfadfg","klj323jf43f2oi3j"));
        personList.add( new Person("raja","42","dfsdfgaddsdffg","klj32ref34f343j2oi3j"));


        SimpleBeanPropertyFilter simpleBeanPropertyFilter  = SimpleBeanPropertyFilter.filterOutAllExcept("password","ssn");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("PersonFilter",simpleBeanPropertyFilter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(personList);
        mappingJacksonValue.setFilters(filterProvider);


        return mappingJacksonValue;

    }
}
