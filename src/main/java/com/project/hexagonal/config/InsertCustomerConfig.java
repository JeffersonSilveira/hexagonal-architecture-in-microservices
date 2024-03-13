package com.project.hexagonal.config;

import com.project.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.project.hexagonal.adapters.out.InsertCustomerAdapter;
import com.project.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.project.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }

}
