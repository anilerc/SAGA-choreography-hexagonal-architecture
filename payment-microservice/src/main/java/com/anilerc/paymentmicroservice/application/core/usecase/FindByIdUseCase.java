package com.anilerc.paymentmicroservice.application.core.usecase;

import com.anilerc.paymentmicroservice.application.core.domain.Customer;
import com.anilerc.paymentmicroservice.application.ports.in.FindCustomerByIdInputPort;
import com.anilerc.paymentmicroservice.application.ports.out.FindCustomerByIdOutputPort;

public class FindByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;


    public FindByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(final Integer id) {
        return findCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("No such customer exists!"));
    }
}
