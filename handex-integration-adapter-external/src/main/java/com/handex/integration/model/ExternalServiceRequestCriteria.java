package com.handex.integration.model;

public class ExternalServiceRequestCriteria {

    private String country;

    private String name;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return (name != null) ? name : "No record name set";
    }
}