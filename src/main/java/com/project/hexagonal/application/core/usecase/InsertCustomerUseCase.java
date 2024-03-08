package com.project.hexagonal.application.core.usecase;

import com.project.hexagonal.application.core.domain.Customer;
import com.project.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.project.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.project.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private  final InsertCustomerOutputPort insertCustomerOutputPOrt;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPOrt) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPOrt = insertCustomerOutputPOrt;
    }
    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPOrt.insert(customer);

    }
}
