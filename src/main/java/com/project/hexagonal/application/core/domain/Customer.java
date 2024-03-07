package com.project.hexagonal.application.core.domain;

public class Customer {
    public Customer() {
        this.isValidCpf = false;
    }

    public Customer(String id, String name, Addess addess, String cpf, Boolean isValidCpf) {
        this.id = id;
        this.name = name;
        this.addess = addess;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }

    private  String id;
    private  String name;
    private Addess addess;
    private  String cpf;
    private  Boolean isValidCpf;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Addess getAddess() {
        return addess;
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

    public void setAddess(Addess addess) {
        this.addess = addess;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }
}
