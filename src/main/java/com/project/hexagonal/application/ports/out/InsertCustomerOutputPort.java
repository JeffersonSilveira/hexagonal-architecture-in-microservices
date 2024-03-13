package com.project.hexagonal.application.ports.out;

import com.project.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);

}
