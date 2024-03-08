package com.project.hexagonal.adapters.out;

import com.project.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.project.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.project.hexagonal.application.core.domain.Address;
import com.project.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressReponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressReponse);
    }
}
