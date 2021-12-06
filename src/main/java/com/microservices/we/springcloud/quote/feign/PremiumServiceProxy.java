package com.microservices.we.springcloud.quote.feign;

import com.microservices.we.springcloud.quote.dao.Premium;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "PremiumServiceClient", url = "localhost:8082")
@FeignClient(name = "msinsurencewe")
public interface PremiumServiceProxy {


    @GetMapping("/premium/{coverages}")
    public Premium generatePreium(@PathVariable(value = "coverages")  String[] coverages);

}
