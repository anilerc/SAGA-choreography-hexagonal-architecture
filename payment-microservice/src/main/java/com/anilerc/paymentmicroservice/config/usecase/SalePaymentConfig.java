package com.anilerc.paymentmicroservice.config.usecase;

import com.anilerc.paymentmicroservice.adapters.out.SavePaymentAdapter;
import com.anilerc.paymentmicroservice.adapters.out.SendEventAdapter;
import com.anilerc.paymentmicroservice.adapters.out.UpdateCustomerAdapter;
import com.anilerc.paymentmicroservice.application.core.usecase.FindByIdUseCase;
import com.anilerc.paymentmicroservice.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(FindByIdUseCase findByIdUseCase, UpdateCustomerAdapter updateCustomerAdapter, SavePaymentAdapter savePaymentAdapter, SendEventAdapter sendEventAdapter) {
        return new SalePaymentUseCase(findByIdUseCase, updateCustomerAdapter, savePaymentAdapter, sendEventAdapter);
    }
}
