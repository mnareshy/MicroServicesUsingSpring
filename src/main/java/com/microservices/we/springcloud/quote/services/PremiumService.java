package com.microservices.we.springcloud.quote.services;

import com.microservices.we.springcloud.quote.dao.Premium;
import com.microservices.we.springcloud.quote.dao.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PremiumService {


    @Autowired
    Environment environment;

    @GetMapping("/premium/{coverages}")//
    public Premium generatePreium(@PathVariable String[] coverages){

        Long totalPremium = 0l;

        System.out.println("********************"+coverages);

        for (String coverage:coverages ) {

            System.out.println("********************"+coverage);

            switch (coverage){

                case "Body_coverage": totalPremium =totalPremium + 2000;
                    break;

                case "3rd_party_coverage":  totalPremium =totalPremium + 2000;
                    break;

                default: totalPremium =totalPremium + 2000;

            }

        }

        String port = environment.getProperty("local.server.port");
        Premium premium = new Premium(coverages,totalPremium);
        premium.setEnvironment(port);


        return premium;
    }
}


