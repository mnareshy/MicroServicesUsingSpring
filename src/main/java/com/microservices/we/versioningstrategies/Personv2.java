package com.microservices.we.versioningstrategies;

public class Personv2 {
    Name name;

    public Personv2(Name name) {
        this.name = name;
    }

    public Personv2() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

}
