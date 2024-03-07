package com.project.hexagonal.application.core.domain;

public class Addess {
    public Addess() {
    }

    public Addess(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    private String street;
    private  String city;
    private String state;

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }
}
