package com.microservices.we.resilience.retryandfallback;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class RetryAndFallbackRestController {

    Logger logger = LoggerFactory.getLogger(RetryAndFallbackRestController.class);

   @GetMapping("/resilientservice")
   @Retry(name = "defult", fallbackMethod = "fallbackmethod")
    public String theResilientService(){

       logger.info("Retry");
       ResponseEntity<String> responseEntity =  new RestTemplate().getForEntity("http://thenothing:8080/nothing",String.class);

       return responseEntity.getBody();


    }

    public String fallbackmethod(Exception exception){

       return "Fall Back On Me!";
    }



}
