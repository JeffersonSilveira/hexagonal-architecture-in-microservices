package com.project.hexagonal.adapters.out.client.mapper;

import com.project.hexagonal.adapters.out.client.response.AddressResponse;
import com.project.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
