package com.project.hexagonal.application.ports.out;

import com.project.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipcode);

}
