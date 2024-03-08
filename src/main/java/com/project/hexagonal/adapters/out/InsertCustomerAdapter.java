package com.project.hexagonal.adapters.out;

import com.project.hexagonal.adapters.out.repository.CustomerRepository;
import com.project.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.project.hexagonal.application.core.domain.Customer;
import com.project.hexagonal.application.ports.out.InsertCustomerOutputPOrt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter  implements InsertCustomerOutputPOrt {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customeEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customeEntity);

    }
}
