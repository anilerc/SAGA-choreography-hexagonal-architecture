package com.anilerc.paymentmicroservice.application.ports.out;

import com.anilerc.paymentmicroservice.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
