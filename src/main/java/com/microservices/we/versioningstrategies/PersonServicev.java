package com.microservices.we.versioningstrategies;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonServicev {


   /*
   * URL Based Versioning
   *
   * */

   @GetMapping("/v1/person")
    public Personv1 gerPersonv1(){

        return new Personv1("APJ Abdul Kalam");

    }

    @GetMapping("/v2/person")
    public Personv2 gerPersonv2(){

        return new Personv2(new Name("APJ Abdul","Kalam"));

    }


    /*
     * URL Based Versioning
     *
     * */
    /*
     * Request Parem Based Versioning
     *
     * localhost:8080\person\param?v1
     *
     * localhost:8080\person\param?v2
     * */

    @GetMapping(value =  "/person/param", params = "v1")
    public Personv1 gerPersonvRP1(){

        return new Personv1("APJ Abdul Kalam");

    }

    @GetMapping(value =  "/person/param", params = "v2")
    public Personv2 gerPersonvRP2(){

        return new Personv2(new Name("APJ Abdul","Kalam"));

    }

    /*
     * Request Parem Based Versioning
     *
     * */



    /*
     * Header Based Versioning
     *
     * localhost:8080\person\header   -- headers -- "X-API-VERSION=1" : 1
     *
     * localhost:8080\person\header   -- headers -- "X-API-VERSION=1" : 2
     * */

    @GetMapping(value =  "/person/header", headers = "X-API-VERSION=1")
    public Personv1 gerPersonvHeader1(){

        return new Personv1("APJ Abdul Kalam");

    }

    @GetMapping(value =  "/person/header", headers = "X-API-VERSION=2")
    public Personv2 gerPersonvHeader2(){

        return new Personv2(new Name("APJ Abdul","Kalam"));

    }

    /*
     * Header Based Versioning
     *
     * */

    /*
     * Produces Based Versioning
     *
     * localhost:8080\person\produces   -- headers produces  -- "Accept" : "application/vnd.company.app-v1+json"
     *
     * localhost:8080\person\produces   -- headers produces -- "Accept" : "application/vnd.company.app-v2+json"
     * */

    @GetMapping(value =  "/person/produces", produces = "application/vnd.company.app-v1+json")
    public Personv1 gerPersonvProducesV1(){

        return new Personv1("APJ Abdul Kalam");

    }

    @GetMapping(value =  "/person/produces", produces = "application/vnd.company.app-v2+json")
    public Personv2 gerPersonvProducesV2(){

        return new Personv2(new Name("APJ Abdul","Kalam"));

    }

    /*
     * Header Based Versioning
     *
     * */
}
