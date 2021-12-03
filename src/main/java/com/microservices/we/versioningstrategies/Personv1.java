package com.microservices.we.versioningstrategies;

public class Personv1 {

    String name;

    public Personv1(String name) {
        this.name = name;
    }

    public Personv1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
