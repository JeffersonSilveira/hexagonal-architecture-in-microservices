package com.project.hexagonal.adapters.in.controller;

import com.project.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.project.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.project.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.project.hexagonal.application.core.domain.Customer;
import com.project.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.project.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.project.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.project.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;


    @Autowired
    private CustomerMapper customerMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;


    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);

        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{d}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponser = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponser);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }


}
