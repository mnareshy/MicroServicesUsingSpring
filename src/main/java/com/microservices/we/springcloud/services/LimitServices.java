package com.microservices.we.springcloud.services;

import com.microservices.we.springcloud.configurations.Configuration;
import com.microservices.we.springcloud.vo.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitServices {

    @Autowired
    Configuration configuration;

    @GetMapping("/insurance/limits")
    public Limits getInsuranceLimits(){

        return new Limits(configuration.getMinValue(),configuration.getMaxValue());
    }

}
