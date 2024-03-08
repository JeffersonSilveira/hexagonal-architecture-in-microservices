package com.project.hexagonal.application.core.domain;


public class Customer {

    public Customer() {
        this.isValidCpf = false;
    }

    public Customer(String id, String name, Address address, String cpf, Boolean isValidCpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }

    private String id;

    private  String name;

    private Address address;

    private String cpf;

    private Boolean isValidCpf;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getCpf() {
        return cpf;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }
}
