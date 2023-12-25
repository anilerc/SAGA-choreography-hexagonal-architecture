package com.anilerc.paymentmicroservice.application.ports.out;

import com.anilerc.paymentmicroservice.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {


    Optional<Customer> find(Integer id);
}
