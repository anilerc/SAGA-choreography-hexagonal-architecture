package com.anilerc.paymentmicroservice.adapters.out;

import com.anilerc.paymentmicroservice.adapters.out.repository.CustomerRepository;
import com.anilerc.paymentmicroservice.adapters.out.repository.mapper.CustomerEntityMapper;
import com.anilerc.paymentmicroservice.application.core.domain.Customer;
import com.anilerc.paymentmicroservice.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdOutputAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerByIdOutputAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }


    @Override
    public Optional<Customer> find(Integer id) {

        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);

    }
}
