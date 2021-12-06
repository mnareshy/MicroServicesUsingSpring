package com.microservices.we.springcloud.vo;

import org.springframework.stereotype.Component;

@Component
public class Limits {

    private Long minValue;
    private Long maxValue;


    public Limits() {
    }

    public Limits(Long minValue, Long maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public Long getMinValue() {
        return minValue;
    }

    public void setMinValue(Long minValue) {
        this.minValue = minValue;
    }

    public Long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
    }
}

