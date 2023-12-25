package com.anilerc.paymentmicroservice.config.usecase;

import com.anilerc.paymentmicroservice.adapters.out.FindCustomerByIdOutputAdapter;
import com.anilerc.paymentmicroservice.application.core.usecase.FindByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByIdConfig {

    @Bean
    public FindByIdUseCase findCustomerByIdUseCase(FindCustomerByIdOutputAdapter findCustomerByIdOutputAdapter) {
        return new FindByIdUseCase(findCustomerByIdOutputAdapter);
    }

}
