package com.anilerc.paymentmicroservice.application.ports.in;

import com.anilerc.paymentmicroservice.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(final Integer id);

}
