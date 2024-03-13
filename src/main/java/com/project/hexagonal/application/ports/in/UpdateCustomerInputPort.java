package com.project.hexagonal.application.ports.in;

import com.project.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
