package com.project.hexagonal.adapters.out.repository.entity;

import com.project.hexagonal.application.core.domain.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "customers")
public class CustomerEntity {

    @Id
    private String id;

    private  String name;

    private AddressEnity address;

    private String cpf;

    private Boolean isValidCpf;
}
