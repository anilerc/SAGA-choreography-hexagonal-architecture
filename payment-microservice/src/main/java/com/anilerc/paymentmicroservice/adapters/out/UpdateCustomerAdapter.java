package com.anilerc.paymentmicroservice.adapters.out;

import com.anilerc.paymentmicroservice.adapters.out.repository.CustomerRepository;
import com.anilerc.paymentmicroservice.adapters.out.repository.mapper.CustomerEntityMapper;
import com.anilerc.paymentmicroservice.application.core.domain.Customer;
import com.anilerc.paymentmicroservice.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {


    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.fromCustomerToCustomerEntity(customer);
        customerRepository.save(customerEntity);


    }
}
