package com.project.hexagonal.application.ports.in;

import com.project.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
