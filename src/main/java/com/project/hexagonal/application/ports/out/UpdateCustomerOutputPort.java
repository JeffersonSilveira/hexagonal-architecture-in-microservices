package com.project.hexagonal.application.ports.out;

import com.project.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);

}
