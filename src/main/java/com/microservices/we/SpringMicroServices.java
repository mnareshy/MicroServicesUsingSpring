package com.microservices.we;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class SpringMicroServices {

    public static void main(String[] args) {

        SpringApplication.run(SpringMicroServices.class);

    }

}
