package com.anilerc.paymentmicroservice.adapters.out.repository.mapper;

import com.anilerc.paymentmicroservice.adapters.out.repository.entity.CustomerEntity;
import com.anilerc.paymentmicroservice.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    Customer toCustomer(CustomerEntity customerEntity);

    CustomerEntity fromCustomerToCustomerEntity(Customer customer);

}
