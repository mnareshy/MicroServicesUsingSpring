package com.microservices.we.resilience.ratelimiterbulkhead;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/*
* #Ratelimiting
resilience4j.ratelimiter.instances.default.limitForPeriod=2
resilience4j.ratelimiter.instances.default.limitRefreshPeriod=10s
*
*
*#BulkHead
resilience4j.bulkhead.instances.default.maxConcurrentCalls=12
*
* */
@RestController
public class RateService {

    Logger logger = LoggerFactory.getLogger(RateService.class);

   @GetMapping("/ratelimiterbulkhead")
 //  @RateLimiter(name = "default")
   @Bulkhead(name = "default")
    public String theResilientRateLimiterBulkHeadService(){

       logger.info("ratelimiterbulkhead");
       ResponseEntity<String> responseEntity =  ResponseEntity.status(HttpStatus.CREATED.value()).body("theResilientRateLimiterBulkHeadService");

       return responseEntity.getBody();


    }

    public String fallbackmethod(Exception exception){

       return "Fall Back On Me!";
    }



}
