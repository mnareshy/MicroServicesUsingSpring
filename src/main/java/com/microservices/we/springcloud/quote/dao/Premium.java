package com.microservices.we.springcloud.quote.dao;

public class Premium {


    private String[] coverages;
    private Long premium;

    private String environment;

    public Premium(String[] coverages, Long premium) {

        this.coverages = coverages;
        this.premium = premium;
    }

    public Premium() {
    }



    public String[] getCoverages() {
        return coverages;
    }

    public void setCoverages(String[] coverages) {
        this.coverages = coverages;
    }

    public Long getPremium() {
        return premium;
    }

    public void setPremium(Long premium) {
        this.premium = premium;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
