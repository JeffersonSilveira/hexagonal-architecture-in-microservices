package com.project.hexagonal.application.ports.in;

import com.project.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);

}
