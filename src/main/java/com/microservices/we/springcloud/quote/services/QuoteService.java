package com.microservices.we.springcloud.quote.services;

import com.microservices.we.springcloud.quote.dao.Premium;
import com.microservices.we.springcloud.quote.dao.Quote;
import com.microservices.we.springcloud.quote.feign.PremiumServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class QuoteService {

    @Autowired
    Environment environment;

 /*   @Autowired
    RestTemplate restTemplate;*/

    @GetMapping("/quote/premium/{name}/{vehicleNumber}")
    public Quote genarateQuote(@PathVariable String name, @PathVariable String vehicleNumber){

        String []coverages = {"Body_coverage","3rd_party_coverage"};

        HashMap<String,String> pathVariables = new HashMap<>();
        pathVariables.put("coverages","Body_coverage,3rd_party_coverage");

        ResponseEntity<Premium> responseEntity =
                new RestTemplate().getForEntity("http://localhost:8080//premium/{coverages}",Premium.class,pathVariables);

        Premium premium = responseEntity.getBody();

        Quote quote = new Quote(name,vehicleNumber,coverages, premium.getPremium());
        String port = environment.getProperty("local.server.port");

        quote.setEnvironment(port);

        return quote;
    }

    @Autowired
    PremiumServiceProxy premiumServiceProxy;


    @GetMapping("/quote/premium/feign/{name}/{vehicleNumber}")
    public Quote genarateQuoteWithFeignProxyForPremium(@PathVariable String name, @PathVariable String vehicleNumber){

        String []coverages = {"Body_coverage","3rd_party_coverage"};


        Premium premium = premiumServiceProxy.generatePreium(coverages);

        Quote quote = new Quote(name,vehicleNumber,coverages, premium.getPremium());
        String port = environment.getProperty("local.server.port");

//       port = "Quote connected to -> "+port +" and invoking Premium genaration from ->"+ premium.getEnvironment();

        quote.setEnvironment(port);

        return quote;
    }
}
