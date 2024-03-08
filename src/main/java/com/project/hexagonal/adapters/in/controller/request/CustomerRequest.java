package com.project.hexagonal.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank
    private  String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String zipCode;
}
