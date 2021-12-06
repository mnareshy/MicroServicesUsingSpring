package com.microservices.we.springcloud.quote.dao;

public class Quote {

    private String insururName;
    private String vehicaleNumber;
    private String[] coverages;
    private Long premium;

    private String environment;

    public Quote(String insururName, String vehicaleNumber, String[] coverages, Long premium) {
        this.insururName = insururName;
        this.vehicaleNumber = vehicaleNumber;
        this.coverages = coverages;
        this.premium = premium;
    }

    public Quote() {
    }

    public String getInsururName() {
        return insururName;
    }

    public void setInsururName(String insururName) {
        this.insururName = insururName;
    }

    public String getVehicaleNumber() {
        return vehicaleNumber;
    }

    public void setVehicaleNumber(String vehicaleNumber) {
        this.vehicaleNumber = vehicaleNumber;
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
